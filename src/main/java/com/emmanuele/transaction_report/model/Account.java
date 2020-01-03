package com.emmanuele.transaction_report.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.emmanuele.transaction_report.converter.ofx.OfxHelper;

public class Account {

	/**
	 * Accounts types which are used by the OFX standard
	 */
	public enum OfxAccountType {
		CHECKING, SAVINGS, MONEYMRKT, CREDITLINE
	}

	private String iban;
	private String currencyCode;
	private AccountType accountType = AccountType.CASH;
	private List<Transaction> transactions = new ArrayList<>();

	/**
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * @param iban the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currencyCode the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * @return the accountType
	 */
	public AccountType getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the transactions
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void toOfx(Document doc, Element parent) {
		Element currency = doc.createElement(OfxHelper.TAG_CURRENCY_DEF);
		currency.appendChild(doc.createTextNode(currencyCode));

		// ================= BEGIN BANK ACCOUNT INFO (BANKACCTFROM)
		// =================================

		Element acctId = doc.createElement(OfxHelper.TAG_ACCOUNT_ID);
		acctId.appendChild(doc.createTextNode(iban));

		Element accttype = doc.createElement(OfxHelper.TAG_ACCOUNT_TYPE);
		String ofxAccountType = convertToOfxAccountType(accountType).toString();
		accttype.appendChild(doc.createTextNode(ofxAccountType));

		Element bankFrom = doc.createElement(OfxHelper.TAG_BANK_ACCOUNT_FROM);
		bankFrom.appendChild(acctId);
		bankFrom.appendChild(accttype);

		// ================= END BANK ACCOUNT INFO
		// ============================================

		// ================= BEGIN TRANSACTIONS LIST =================================
		Element bankTransactionsList = doc.createElement(OfxHelper.TAG_BANK_TRANSACTION_LIST);

		for (Transaction transaction : transactions) {
			bankTransactionsList.appendChild(transaction.toOFX(doc));
		}
		// ================= END TRANSACTIONS LIST =================================

		Element statementTransactions = doc.createElement(OfxHelper.TAG_STATEMENT_TRANSACTIONS);
		statementTransactions.appendChild(currency);
		statementTransactions.appendChild(bankFrom);
		statementTransactions.appendChild(bankTransactionsList);

		parent.appendChild(statementTransactions);
	}

	public static OfxAccountType convertToOfxAccountType(AccountType accountType) {
		switch (accountType) {
		case CREDIT:
		case LIABILITY:
			return OfxAccountType.CREDITLINE;

		case CASH:
		case INCOME:
		case EXPENSE:
		case PAYABLE:
		case RECEIVABLE:
			return OfxAccountType.CHECKING;

		case BANK:
		case ASSET:
			return OfxAccountType.SAVINGS;

		case MUTUAL:
		case STOCK:
		case EQUITY:
		case CURRENCY:
			return OfxAccountType.MONEYMRKT;

		default:
			return OfxAccountType.CHECKING;
		}
	}

}
