/*
 * Copyright (c) 2012 - 2014 Ngewi Fet <ngewif@gmail.com>
 * Copyright (c) 2014 Yongxin Wang <fefe.wyx@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.emmanuele.transaction_report.converter.ofx;

import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

import com.emmanuele.transaction_report.model.Account;
import com.emmanuele.transaction_report.model.Transaction;

/**
 * Exports the data in the database in OFX format
 * 
 * @author Ngewi Fet <ngewi.fet@gmail.com>
 * @author Yongxin Wang <fefe.wyx@gmail.com>
 */
public class OfxExporter {

	/**
	 * List of accounts in the expense report
	 */
	private List<Account> accounts;
	private boolean useXmlHeader;

	/**
	 * Builds an XML representation of the {@link Account}s and {@link Transaction}s
	 * in the database
	 */
	public OfxExporter(List<Account> accounts, boolean useXmlHeader) {
		this.accounts = accounts;
		this.useXmlHeader = useXmlHeader;
	}

	/**
	 * Converts all expenses into OFX XML format and adds them to the XML document
	 * 
	 * @param doc    DOM document of the OFX expenses.
	 * @param parent Parent node for all expenses in report
	 */
	private void generateOfx(Document doc, Element parent) {
		Element statementTransactionResponse = doc.createElement(OfxHelper.TAG_STATEMENT_TRANSACTION_RESPONSE);

		Element bankmsgs = doc.createElement(OfxHelper.TAG_BANK_MESSAGES_V1);
		bankmsgs.appendChild(statementTransactionResponse);

		parent.appendChild(bankmsgs);

		for (Account account : accounts) {
			account.toOfx(doc, statementTransactionResponse);
		}
	}

	/**
	 * Generate OFX export file from the transactions in the database
	 * 
	 * @return String containing OFX export
	 * @throws TransformerException
	 * @throws ExporterException
	 */
	public String generateOfxExport() throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		docBuilder = docFactory.newDocumentBuilder();

		Document document = docBuilder.newDocument();
		Element root = document.createElement("OFX");

		ProcessingInstruction pi = document.createProcessingInstruction("OFX", OfxHelper.OFX_HEADER);
		document.appendChild(pi);
		document.appendChild(root);

		generateOfx(document, root);

		StringWriter stringWriter = new StringWriter();
		// if we want SGML OFX headers, write first to string and then prepend header
		if (useXmlHeader) {
			write(document, stringWriter, false);
			return stringWriter.toString();
		} else {
			Node ofxNode = document.getElementsByTagName("OFX").item(0);
			write(ofxNode, stringWriter, true);
			return OfxHelper.OFX_SGML_HEADER + '\n' + stringWriter.toString();
		}
	}

	/**
	 * Writes out the document held in <code>node</code> to
	 * <code>outputWriter</code>
	 * 
	 * @param node               {@link Node} containing the OFX document structure.
	 *                           Usually the parent node
	 * @param outputWriter       {@link java.io.Writer} to use in writing the file
	 *                           to stream
	 * @param omitXmlDeclaration Flag which causes the XML declaration to be omitted
	 */
	private void write(Node node, Writer outputWriter, boolean omitXmlDeclaration) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(node);
		StreamResult result = new StreamResult(outputWriter);

		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		if (omitXmlDeclaration) {
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		}

		transformer.transform(source, result);
	}

	/**
	 * Returns the MIME type for this exporter.
	 * 
	 * @return MIME type as string
	 */
	public String getExportMimeType() {
		return "text/xml";
	}
}
