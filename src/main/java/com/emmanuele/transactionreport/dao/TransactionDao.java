package com.emmanuele.transactionreport.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.emmanuele.transactionreport.Transaction;

public class TransactionDao extends AbstractDao<Transaction> implements
		RowMapper<Transaction> {

	private static final String TABLE_NAME = "TRANSACTIONS";

	private static TransactionDao instance;

	private TransactionDao() {
	}

	public static TransactionDao getInstance() {
		if (instance == null) {
			instance = new TransactionDao();
		}
		return instance;
	}

	public void create(final Transaction transaction) {
		final String query = "INSERT INTO TRANSACTION_REPORT."
				+ TABLE_NAME
				+ " (TRANSACTION_DATE_TIME, VALUE_DATE, REASON, DESCRIPTION, CURRENCY, "
				+ "CURRENCY_AMOUNT, CARD_NUMBER, EUR_AMOUNT, COUNTERPART, ATM_NAME, "
				+ "COUNTERPART_IBAN, PAYMENT_REASON) "
				+ "VALUES "
				+ "(:transactionDateTime, :valueDate, :reason, :description, :currency, "
				+ ":currencyAmount, :cardNumber, :eurAmount, :counterpart, :atmName, "
				+ ":counterpartIban, :paymentReason)";
		final Map<String, Object> params = new HashMap<>();
		//FIXME time zone issue
		Timestamp transactionDateTime = null;
		if (transaction.getTransactionDateTime() != null) {
			transactionDateTime = Timestamp
					.from(transaction.getTransactionDateTime().toInstant(
							ZoneOffset.ofHours(-2)));
		}
		params.put("transactionDateTime", transactionDateTime);
		java.sql.Date valueDate = null;
		if (transaction.getValueDate() != null) {
			valueDate = new java.sql.Date(Date.from(
					transaction.getValueDate().atStartOfDay()
							.toInstant(ZoneOffset.ofHours(-2))).getTime());
		}
		params.put("valueDate", valueDate);
		params.put("reason", transaction.getReason());
		params.put("description", transaction.getDescription());
		params.put("currency", transaction.getCurrency());
		params.put("currencyAmount", transaction.getCurrencyAmount());
		params.put("cardNumber", transaction.getCardNumber());
		params.put("eurAmount", transaction.getEurAmount());
		params.put("counterpart", transaction.getCounterpart());
		params.put("atmName", transaction.getAtmName());
		params.put("counterpartIban", transaction.getCounterpartIban());
		params.put("paymentReason", transaction.getPaymentReason());
		jdbcTemplate.update(query, params);
	}

	public List<Transaction> findByYear(final int year) {
		final String query = "select * from transaction where anno = :year";
		final Map<String, Object> params = new HashMap<>();
		params.put("year", year);
		return jdbcTemplate.query(query, params, getRowMapper());
	}

	@Override
	public void update(Transaction transaction) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected RowMapper<Transaction> getRowMapper() {
		return this;
	}

	@Override
	protected String getTableName() {
		return TABLE_NAME;
	}

	public Transaction mapRow(final ResultSet rs, final int line)
			throws SQLException {
		final Transaction transaction = new Transaction();
		// TODO
		return transaction;
	}

}
