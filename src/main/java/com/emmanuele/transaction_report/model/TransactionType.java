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

/**
 * Type of transaction, according to the OFX standard, version 2.2.
 */
public enum TransactionType {

	/** Generic credit. */
	CREDIT,
	/** Generic debit. */
	DEBIT,
	/**
	 * Interest earned or paid.
	 * Note: Depends on signage of amount.
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
	 * ATM debit or credit. 
	 * Note: Depends on signage of amount.
	 */
	ATM,
	/**
	 * Point of sale debit or credit.
	 * Note: Depends on signage of amount.
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
	 * Only valid in <STMTTRNP>; indicates the amount is under a hold.
	 * Note: Depends on signage of amount and account type.
	 */
	HOLD,
	/** Other. */
	OTHER;

}
