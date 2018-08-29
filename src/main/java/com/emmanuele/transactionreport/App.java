package com.emmanuele.transactionreport;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.emmanuele.transaction_report.bindings.Table;
import com.emmanuele.transaction_report.bindings.Tr;
import com.emmanuele.transactionreport.dao.DbConf;
import com.emmanuele.transactionreport.dao.TransactionDao;
import com.emmanuele.transactionreport.dao.TransactionReportDataSource;

public class App {

	private static final String DESCRIPTION_HEADER = "Descrizione operazione";

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter
			.ofPattern("dd/MM/yyyy");

	private static final Logger log = LoggerFactory.getLogger(App.class);

	// The JAXB context is thread-safe, so the same instance can be used through
	// multiple calls.
	private static JAXBContext context = null;
	static {
		try {
			context = JAXBContext
					.newInstance("com.emmanuele.transaction_report.bindings");
		} catch (JAXBException e) {
			log.error("Error while initializing logger", e);
		}
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			log.error("Missing file path");
			return;
		}
		try {
			final String filePath = args[0];
			final String fileContent = readFile(filePath).replace('\t', ' ')
					.replace("   ", " ");
			final Table table = parseXml(fileContent);
			final List<Transaction> transactions = buildTransactions(table);
			final Properties properties = buildDbProperties();
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

	private static String readFile(final String filePath) throws IOException {
		final StringBuilder transactionsFileStr = new StringBuilder();
		try (final FileReader fr = new FileReader(filePath);
				final BufferedReader br = new BufferedReader(fr);) {
			String line;
			while ((line = br.readLine()) != null) {
				transactionsFileStr.append(line);
			}
		}
		return transactionsFileStr.toString();
	}

	private static Table parseXml(String fileContent) throws JAXBException,
			UnsupportedEncodingException {
		final Unmarshaller u = context.createUnmarshaller();
		return (Table) u.unmarshal(new ByteArrayInputStream(fileContent
				.getBytes(StandardCharsets.UTF_8.name())));
	}

	private static List<Transaction> buildTransactions(final Table table) {
		final List<Transaction> transactions = new ArrayList<>();
		for (final Tr row : table.getTr()) {
			try {
				final String description = row.getTd().get(3).getContent();
				log.info(description);
				if (DESCRIPTION_HEADER.equals(description)) {
					continue;
				}
				transactions.add(buildTransaction(row));
			} catch (Exception e) {
				log.error("", e);
			}
		}
		return transactions;
	}

	private static Transaction buildTransaction(final Tr row) {
		final String description = row.getTd().get(3).getContent();
		final String reason = row.getTd().get(2).getContent();
		final Transaction transaction = TransactionDescriptionParser
				.parseDescription(description);
		transaction.setValueDate(LocalDate.parse(row.getTd().get(0)
				.getContent(), DATE_FORMATTER));
		transaction.setReason(reason);
		transaction.setDescription(description);
		final String currencyAndAmount = row.getTd().get(4).getContent().trim()
				.replaceAll("\\.", "").replace(',', '.').replaceAll(" ", "");
		final String currency = currencyAndAmount.substring(0, 3);
		transaction.setCurrency(currency);
		final String currencyAmount = currencyAndAmount.substring(3,
				currencyAndAmount.length());
		transaction.setCurrencyAmount(Double.valueOf(currencyAmount));
		log.info(transaction.toString());
		return transaction;
	}

	private static Properties buildDbProperties() {
		final Properties properties = new Properties();
		properties.setProperty("DB_USER", "");
		properties.setProperty("DB_PSW", "");
		properties.setProperty("DB_DRIVER", "com.mysql.jdbc.Driver");
		properties.setProperty("DB_URL", "");
		return properties;
	}

}
