package com.emmanuele.transactionreport.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

public abstract class AbstractDao<T> {

	protected NamedParameterJdbcTemplate jdbcTemplate;
	protected TransactionTemplate transactionTemplate;

	public void init(final DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		final DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(
				dataSource);
		transactionTemplate = new TransactionTemplate(transactionManager);
	}

	public abstract void create(final T object);

	public void create(final List<T> objects) {
		transactionTemplate.execute(status -> {
			for (final T object : objects) {
				create(object);
			}
			return null;
		});
	}

	public abstract void update(final T object);

	public void update(final List<T> objects) {
		transactionTemplate.execute(status -> {
			for (final T object : objects) {
				update(object);
			}
			return null;
		});
	}

	public List<T> selectAll() {
		return jdbcTemplate.query(
				String.format("select %s from film", getTableName()),
				getRowMapper());
	}

	protected abstract RowMapper<T> getRowMapper();

	protected abstract String getTableName();

}
