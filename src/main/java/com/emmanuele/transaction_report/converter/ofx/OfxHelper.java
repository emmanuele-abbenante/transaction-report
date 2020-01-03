/*
 * Copyright (c) 2014 Ngewi Fet <ngewif@gmail.com>
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

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

/**
 * Helper class with collection of useful method and constants for the OFX
 * export
 *
 * @author Ngewi Fet <ngewif@gmail.com>
 */
public class OfxHelper {

	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
	public static final DecimalFormat AMOUNT_FORMATTER = new DecimalFormat("0.00");

	/**
	 * Header for OFX documents
	 */
	public static final String OFX_HEADER = "OFXHEADER=\"200\" VERSION=\"211\" SECURITY=\"NONE\" OLDFILEUID=\"NONE\" NEWFILEUID=\"NONE\"";

	/**
	 * SGML header for OFX. Used for compatibility with desktop GnuCash
	 */
	public static final String OFX_SGML_HEADER = "ENCODING:UTF-8\nOFXHEADER:100\nDATA:OFXSGML\nVERSION:211\nSECURITY:NONE\nCHARSET:UTF-8\nCOMPRESSION:NONE\nOLDFILEUID:NONE\nNEWFILEUID:NONE";

	/*
	 * XML tag name constants for the OFX file
	 */
	public static final String TAG_TRANSACTION_UID = "TRNUID";
	public static final String TAG_BANK_MESSAGES_V1 = "BANKMSGSRSV1";
	public static final String TAG_CURRENCY_DEF = "CURDEF";
	public static final String TAG_BANK_ID = "BANKID";
	public static final String TAG_ACCOUNT_ID = "ACCTID";
	public static final String TAG_ACCOUNT_TYPE = "ACCTTYPE";
	public static final String TAG_BANK_ACCOUNT_FROM = "BANKACCTFROM";
	public static final String TAG_BALANCE_AMOUNT = "BALAMT";
	public static final String TAG_DATE_AS_OF = "DTASOF";
	public static final String TAG_LEDGER_BALANCE = "LEDGERBAL";
	public static final String TAG_DATE_START = "DTSTART";
	public static final String TAG_DATE_END = "DTEND";
	public static final String TAG_TRANSACTION_TYPE = "TRNTYPE";
	public static final String TAG_DATE_POSTED = "DTPOSTED";
	public static final String TAG_DATE_USER = "DTUSER";
	public static final String TAG_TRANSACTION_AMOUNT = "TRNAMT";
	public static final String TAG_TRANSACTION_FITID = "FITID";
	public static final String TAG_NAME = "NAME";
	public static final String TAG_MEMO = "MEMO";
	public static final String TAG_BANK_ACCOUNT_TO = "BANKACCTTO";
	public static final String TAG_BANK_TRANSACTION_LIST = "BANKTRANLIST";
	public static final String TAG_STATEMENT_TRANSACTIONS = "STMTRS";
	public static final String TAG_STATEMENT_TRANSACTION = "STMTTRN";
	public static final String TAG_STATEMENT_TRANSACTION_RESPONSE = "STMTTRNRS";

}
