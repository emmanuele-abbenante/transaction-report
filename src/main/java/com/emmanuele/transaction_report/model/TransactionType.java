/*
 * Copyright (c) 2012 - 2014 Ngewi Fet <ngewif@gmail.com>
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

package com.emmanuele.transaction_report.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.emmanuele.transaction_report.App;
import com.emmanuele.transaction_report.utils.FileUtils;

/**
 * Type of transaction, according to the OFX standard, version 2.2.
 */
public enum TransactionType {

	/** Generic credit. */
	CREDIT,
	/** Generic debit. */
	DEBIT,
	/**
	 * Interest earned or paid. Note: Depends on signage of amount.
	 */
	INT,
	/** Dividend. */
	DIV,
	/** FI fee. */
	FEE,
	/** Service charge. */
	SRVCHG,
	/** Deposit. */
	DEP,
	/**
	 * ATM debit or credit. Note: Depends on signage of amount.
	 */
	ATM,
	/**
	 * Point of sale debit or credit. Note: Depends on signage of amount.
	 */
	POS,
	/** Transfer. */
	XFER,
	/** Check. */
	CHECK,
	/** Electronic payment. */
	PAYMENT,
	/** Cash withdrawal. */
	CASH,
	/** Direct deposit. */
	DIRECTDEP,
	/** Merchant initiated debit. */
	DIRECTDEBIT,
	/** Repeating payment/standing order. */
	REPEATPMT,
	/**
	 * Only valid in <STMTTRNP>; indicates the amount is under a hold. Note: Depends
	 * on signage of amount and account type.
	 */
	HOLD,
	/** Other. */
	OTHER;

	private static final String PROPERTIES_FILE = "transaction_types_mapping.properties";
	private static final String PATTERNS_PROPERTY = "transaction_types_mapping";

	private static final String PIPE_SEPARATOR = "\\|";
	private static final String COLON_SEPARATOR = ":";

	private static final Map<String, TransactionType> MAPPING = new HashMap<>();
	static {
		try {
			final Properties properties = FileUtils.readExternalProperties(App.class, PROPERTIES_FILE);
			for (final String entry : properties.getProperty(PATTERNS_PROPERTY).split(PIPE_SEPARATOR)) {
				final String[] items = entry.split(COLON_SEPARATOR);
				final String transactionType = items[0];
				final String ofxTransactionType = items[1];
				MAPPING.put(transactionType, TransactionType.valueOf(ofxTransactionType));
			}
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static TransactionType getInstance(final String transactionType) {
		final TransactionType instance = MAPPING.get(transactionType);
		if (instance == null) {
			throw new IllegalArgumentException("Unknown transaction type: " + transactionType);
		}
		return instance;
	}

}
