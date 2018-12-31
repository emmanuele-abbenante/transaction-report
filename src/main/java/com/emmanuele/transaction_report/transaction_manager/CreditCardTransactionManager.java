package com.emmanuele.transaction_report.transaction_manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.emmanuele.transaction_report.bindings.Table;
import com.emmanuele.transaction_report.bindings.Tr;
import com.emmanuele.transaction_report.model.Transaction;

public class CreditCardTransactionManager extends BaseTransactionManager {

	private static final String DEFAULT_REASON = "PAGAMENTO CARTA DI CREDITO";
	private static final String EUR_CURRENCY = "EUR";

	private static final Logger log = LoggerFactory
			.getLogger(CreditCardTransactionManager.class);

	private CreditCardTransactionManager() {
	}

	public static List<Transaction> buildTransactions(final String fileContent)
			throws Exception {
		final Table table = parseXml(fileContent);
		final List<Transaction> transactions = new ArrayList<>();
		for (final Tr row : table.getTr()) {
			final String description = row.getTd().get(2).getContent();
			log.info(description);
			if (DESCRIPTION_HEADER.equals(description)
					|| StringUtils.isEmpty(description.trim())) {
				continue;
			}
			transactions.add(buildTransaction(row));
		}
		return transactions;
	}

	private static Transaction buildTransaction(final Tr row) {
		final String description = row.getTd().get(2).getContent();
		final Transaction transaction = new Transaction();
		transaction.setDescription(description);
		transaction.setCounterpart(getCounterparty(description));
		transaction.setValueDate(LocalDate.parse(row.getTd().get(0)
				.getContent(), DATE_FORMATTER));
		transaction.setTransactionDateTime(transaction.getValueDate()
				.atStartOfDay());
		transaction.setReason(DEFAULT_REASON);
		transaction.setCurrency(EUR_CURRENCY);
		final String currencyAmount = row.getTd().get(4).getContent()
				.replace(',', '.');
		transaction.setCurrencyAmount(Double.valueOf(currencyAmount) * -1);
		return transaction;
	}

	private static String getCounterparty(final String description) {
		String counterparty = description;
		for (final Pattern pattern : CounterpartyPatternCache.getInstance()
				.getPatterns()) {
			final Matcher matcher = pattern.matcher(description);
			if (matcher.matches()) {
				counterparty = CounterpartyPatternCache.getInstance()
						.getPatternsCounterpartiesMap().get(pattern.pattern());
				break;
			}
		}
		return counterparty;
	}

}
