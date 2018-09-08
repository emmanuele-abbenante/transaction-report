package com.emmanuele.transactionreport;

import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.emmanuele.transactionreport.dao.DbConf;
import com.emmanuele.transactionreport.dao.TransactionDao;
import com.emmanuele.transactionreport.dao.TransactionReportDataSource;
import com.emmanuele.transactionreport.transaction_manager.CurrentAccountTransactionManager;
import com.emmanuele.transactionreport.utils.FileUtils;

public class App {

	private static final String CONFIG_PROPERTIES_FILE = "config.properties";

	private static final Logger log = LoggerFactory.getLogger(App.class);

	// The JAXB context is thread-safe, so the same instance can be used through
	// multiple calls.
	public static JAXBContext JAXB_CONTEXT = null;
	static {
		try {
			JAXB_CONTEXT = JAXBContext
					.newInstance("com.emmanuele.transaction_report.bindings");
		} catch (JAXBException e) {
			log.error("Error while initializing logger", e);
		}
	}

	public static void main(final String[] args) {
		if (args.length == 0) {
			log.error("Missing file path");
			return;
		}
		try {
			final String filePath = args[0];
			final String fileContent = FileUtils.readFile(filePath)
					.replace('\t', ' ').replace("   ", " ");
			final List<Transaction> transactions = CurrentAccountTransactionManager
					.buildTransactions(fileContent);
			final Properties properties = FileUtils.readProperties(App.class,
					CONFIG_PROPERTIES_FILE);
			DbConf.init(properties);
			final TransactionReportDataSource videoDataSource = TransactionReportDataSource
					.getInstance();
			videoDataSource.init(DbConf.getInstance());

			final TransactionDao dao = TransactionDao.getInstance();
			dao.init(videoDataSource.getDataSource());
			dao.create(transactions);
		} catch (final Exception e) {
			log.error("", e);
		}
	}

}
