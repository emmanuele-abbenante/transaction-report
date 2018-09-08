package com.emmanuele.transaction_report.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class TransactionReportDataSource {

	private DriverManagerDataSource dataSource;
	
	private static TransactionReportDataSource instance;
	
	private TransactionReportDataSource() { }
	
	public void init(final DbConf dbConf) {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbConf.getDbDriver());
		dataSource.setUrl(dbConf.getDbUrl());
		dataSource.setUsername(dbConf.getDbUser());
		dataSource.setPassword(dbConf.getDbPsw());
	}
	
	public static TransactionReportDataSource getInstance() {
		if (instance == null) {
			instance = new TransactionReportDataSource();
		}
		return instance;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	
}
