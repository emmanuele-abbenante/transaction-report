package com.emmanuele.transaction_report.dao;

import java.util.Properties;

/**
 * Database configuration.
 * 
 * @author Claudio Simonetti <claudio.simonetti@everis.com>
 * @version 1.0
 * @since 2016-07-26
 */
public final class DbConf {

	/** Instance. */
	private static DbConf instance = null;

	/** DataBase user. */
	private String dbUser;
	/** DataBase password. */
	private String dbPsw;
	/** DataBase driver. */
	private String dbDriver;
	/** DataBase URL. */
	private String dbUrl;
	/** Resource. */
	private Properties properties;

	/**
	 * Enumerator database configuration settings.
	 * 
	 * @author Fabio Pirola
	 * @version 1.0
	 * @since 2016-07-26
	 */
	public enum DbConfSettings {
		/** DataBase user. */
		DB_USER,
		/** DataBase password. */
		DB_PSW,
		/** DataBase driver. */
		DB_DRIVER,
		/** DataBase URL. */
		DB_URL;
	}

	/**
	 * Constructor.
	 * 
	 * @param anApp
	 *            App.
	 * @param aProperties
	 *            Configuration file name.
	 * @throws Exception 
	 * @throws CustomException
	 *             Error(s).
	 */
	private DbConf(final Properties aProperties) throws Exception {

		this.properties = aProperties;
		this.dbUser = properties.getProperty("DB_USER");
		this.dbPsw = properties.getProperty("DB_PSW");
		this.dbDriver = properties.getProperty("DB_DRIVER");
		this.dbUrl = properties.getProperty("DB_URL");
		if (dbUser == null || dbUser.isEmpty() || dbPsw == null
				|| dbPsw.isEmpty() || dbDriver == null || dbDriver.isEmpty()
				|| dbUrl == null || dbUrl.isEmpty()) {
			throw new Exception(new StringBuilder("Null values in config or")
					.append(" incorrect value found").toString());
		}
	}

	/**
	 * Initialized DataBase instance.
	 * 
	 * @since 2016-07-26
	 * @param aProperties
	 *            Configuration file name.
	 * @throws CustomException
	 *             Error(s).
	 */
	public static void init(final Properties aProperties)
			throws Exception {
		instance = new DbConf(aProperties);
	}

	/**
	 * Get configuration file name.
	 * 
	 * @since 2016-07-26
	 * @return Configuration file name.
	 */
	public Properties getConfFileName() {
		return properties;
	}

	/**
	 * Get database schema.
	 * 
	 * @since 2016-07-26
	 * @return Database schema.
	 */
	public String getDbUser() {
		return dbUser;
	}

	/**
	 * Get database password.
	 * 
	 * @since 2016-07-26
	 * @return Database password.
	 */
	public String getDbPsw() {
		return dbPsw;
	}

	/**
	 * Get DataBase driver.
	 * 
	 * @since 2016-07-26
	 * @return DataBase driver.
	 */
	public String getDbDriver() {
		return dbDriver;
	}

	/**
	 * Get DataBase URL.
	 * 
	 * @since 2016-07-26
	 * @return DataBase URL.
	 */
	public String getDbUrl() {
		return dbUrl;
	}

	/**
	 * Get DataBase instance.
	 * 
	 * @since 2016-07-26
	 * @return DataBase instance.
	 * @throws InstantiationException
	 *             Instance not initialized.
	 */
	public static DbConf getInstance() throws InstantiationException {
		if (instance == null) {
			throw new InstantiationException("DataBase configuration"
					+ " is not initialized");
		}
		return instance;
	}
}
