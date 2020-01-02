package com.emmanuele.transaction_report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.emmanuele.transaction_report.dao.CurrentAccountTransactionPatternDao;
import com.emmanuele.transaction_report.dao.DbConf;
import com.emmanuele.transaction_report.dao.TransactionDao;
import com.emmanuele.transaction_report.dao.TransactionReportDataSource;
import com.emmanuele.transaction_report.model.Transaction;
import com.emmanuele.transaction_report.transaction_manager.CounterpartyPatternCache;
import com.emmanuele.transaction_report.transaction_manager.CreditCardTransactionManager;
import com.emmanuele.transaction_report.transaction_manager.CurrentAccountTransactionManager;
import com.emmanuele.transaction_report.utils.FileUtils;

public class App {

	private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<!DOCTYPE table [<!ENTITY euro \"EUR\">]><body>";
	private static final String XML_FOOTER = "</body>";

	private static final String CONFIG_PROPERTIES_FILE = "config.properties";

	private static final Logger log = LoggerFactory.getLogger(App.class);

	// The JAXB context is thread-safe, so the same instance can be used through
	// multiple calls.
	public static JAXBContext JAXB_CONTEXT = null;
	static {
		try {
			JAXB_CONTEXT = JAXBContext.newInstance("com.emmanuele.transaction_report.bindings");
		} catch (JAXBException e) {
			log.error("Error while initializing logger", e);
		}
	}

	public static void main(final String[] args) {
		if (args.length != 2) {
			System.err.println("Usage: transaction-report.jar <transactions xml> <transactions source>");
			return;
		}
		try {
			initDataSource();
			System.setProperty("javax.xml.accessExternalDTD", "all");

			final String filePath = args[0];
			final String transactionsSource = args[1];
			List<Transaction> transactions = new ArrayList<Transaction>();
			final String xmlContent = clearXmlContent(FileUtils.readFile(filePath));
			if ("CURRENT_ACCOUNT".equals(transactionsSource)) {
				transactions = CurrentAccountTransactionManager.buildTransactions(xmlContent);
			} else if ("CREDIT_CARD".equals(transactionsSource)) {
				transactions = CreditCardTransactionManager.buildTransactions(xmlContent);
			}
			TransactionDao.getInstance().create(transactions);
		} catch (final Exception e) {
			log.error("", e);
		}
	}

	private static void initDataSource() throws Exception {
		final Properties properties = FileUtils.readProperties(App.class, CONFIG_PROPERTIES_FILE);
		DbConf.init(properties);
		final TransactionReportDataSource dataSource = TransactionReportDataSource.getInstance();
		dataSource.init(DbConf.getInstance());
		TransactionDao.getInstance().init(dataSource.getDataSource());
		CurrentAccountTransactionPatternDao.getInstance().init(dataSource.getDataSource());
		CounterpartyPatternCache.getInstance().init(dataSource.getDataSource());
	}

	private static String clearXmlContent(final String xmlContent) throws IOException {
		return XML_HEADER + xmlContent.replace('\t', ' ').replace("   ", " ").replace("& ", "&amp; ")
				.replaceAll("<style>.*</style>", "") + XML_FOOTER;
	}

}
