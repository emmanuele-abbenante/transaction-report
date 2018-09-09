package com.emmanuele.transaction_report.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emmanuele.transaction_report.model.CounterpartyPattern;

public class CounterpartyPatternDao extends AbstractDao<CounterpartyPattern>
		implements RowMapper<CounterpartyPattern> {

	private static final String TABLE_NAME = "COUNTERPARTIES_PATTERNS";

	private static CounterpartyPatternDao instance;

	private CounterpartyPatternDao() {
	}

	public static CounterpartyPatternDao getInstance() {
		if (instance == null) {
			instance = new CounterpartyPatternDao();
		}
		return instance;
	}

	public void create(final CounterpartyPattern counterpartyPattern) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(CounterpartyPattern counterpartyPattern) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected RowMapper<CounterpartyPattern> getRowMapper() {
		return this;
	}

	@Override
	protected String getTableName() {
		return TABLE_NAME;
	}

	public CounterpartyPattern mapRow(final ResultSet rs, final int line)
			throws SQLException {
		final CounterpartyPattern counterpartyPattern = new CounterpartyPattern();
		counterpartyPattern.setPattern(rs.getString("PATTERN"));
		counterpartyPattern.setName(rs.getString("NAME"));
		return counterpartyPattern;
	}

}
