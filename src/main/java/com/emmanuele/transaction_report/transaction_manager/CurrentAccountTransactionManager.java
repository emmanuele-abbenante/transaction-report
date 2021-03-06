package com.emmanuele.transaction_report.transaction_manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.emmanuele.transaction_report.bindings.Body;
import com.emmanuele.transaction_report.bindings.Table;
import com.emmanuele.transaction_report.bindings.Tr;
import com.emmanuele.transaction_report.model.Transaction;

public class CurrentAccountTransactionManager extends BaseTransactionManager {

	private static final Logger log = LoggerFactory
			.getLogger(CurrentAccountTransactionManager.class);

	private CurrentAccountTransactionManager() {
	}

	public static List<Transaction> buildTransactions(final String fileContent)
			throws Exception {
		final Body body = parseXml(fileContent);
		final Table table = body.getTable().get(0);
		final List<Transaction> transactions = new ArrayList<>();
		for (final Tr row : table.getTr()) {
			if (row.getTd().size() != 5) {
				continue;
			}
			final String description = row.getTd().get(3).getContent();
			if (DESCRIPTION_HEADER.equals(description)) {
				continue;
			}
			final Transaction transaction = buildTransaction(row);
			log.debug(transaction.toString());
			transactions.add(transaction);
		}
		return transactions;
	}

	private static Transaction buildTransaction(final Tr row) {
		final String description = row.getTd().get(3).getContent();
		final String reason = row.getTd().get(2).getContent();
		final Transaction transaction = CurrentAccountTransactionDescriptionParser
				.parseDescription(description);
		transaction.setValueDate(LocalDate.parse(row.getTd().get(0)
				.getContent(), DATE_FORMATTER));
		transaction.setReason(reason != null ? reason.trim() : "");
		transaction.setDescription(description);
		final String currencyAndAmount = row.getTd().get(4).getContent().trim()
				.replaceAll("\\.", "").replace(',', '.').replaceAll(" ", "");
		final String currency = currencyAndAmount.substring(0, 3);
		transaction.setCurrency(currency);
		final String currencyAmount = currencyAndAmount.substring(3,
				currencyAndAmount.length());
		transaction.setCurrencyAmount(Double.valueOf(currencyAmount));
		return transaction;
	}

}
