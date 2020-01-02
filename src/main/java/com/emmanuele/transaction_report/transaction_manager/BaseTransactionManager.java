package com.emmanuele.transaction_report.transaction_manager;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.emmanuele.transaction_report.App;
import com.emmanuele.transaction_report.bindings.Body;

public abstract class BaseTransactionManager {

	protected static final String DESCRIPTION_HEADER = "Descrizione operazione";

	protected static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter
			.ofPattern("dd/MM/yyyy");

	protected static Body parseXml(final String fileContent)
			throws JAXBException, UnsupportedEncodingException {
		final Unmarshaller u = App.JAXB_CONTEXT.createUnmarshaller();
		return (Body) u.unmarshal(new ByteArrayInputStream(fileContent
				.getBytes(StandardCharsets.UTF_8.name())));
	}

}
