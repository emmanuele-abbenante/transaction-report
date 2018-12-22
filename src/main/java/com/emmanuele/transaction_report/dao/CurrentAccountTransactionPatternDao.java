package com.emmanuele.transaction_report.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emmanuele.transaction_report.model.CurrentAccountTransactionPattern;

public class CurrentAccountTransactionPatternDao extends AbstractDao<CurrentAccountTransactionPattern>
		implements RowMapper<CurrentAccountTransactionPattern> {

	private static final String TABLE_NAME = "CURR_ACC_TRANS_PATTERNS";

	private static CurrentAccountTransactionPatternDao instance;

	private CurrentAccountTransactionPatternDao() {
	}

	public static CurrentAccountTransactionPatternDao getInstance() {
		if (instance == null) {
			instance = new CurrentAccountTransactionPatternDao();
		}
		return instance;
	}

	public void create(final CurrentAccountTransactionPattern CurrentAccountTransactionPattern) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(CurrentAccountTransactionPattern CurrentAccountTransactionPattern) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected RowMapper<CurrentAccountTransactionPattern> getRowMapper() {
		return this;
	}

	@Override
	protected String getTableName() {
		return TABLE_NAME;
	}

	public CurrentAccountTransactionPattern mapRow(final ResultSet rs, final int line) throws SQLException {
		final CurrentAccountTransactionPattern model = new CurrentAccountTransactionPattern();
		model.setPattern(rs.getString("PATTERN"));
		model.setFields(rs.getString("FIELDS"));
		return model;
	}

}
