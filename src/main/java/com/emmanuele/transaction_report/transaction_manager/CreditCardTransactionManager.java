package com.emmanuele.transaction_report.transaction_manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.emmanuele.transaction_report.bindings.Body;
import com.emmanuele.transaction_report.bindings.Table;
import com.emmanuele.transaction_report.bindings.Tr;
import com.emmanuele.transaction_report.model.Transaction;

public class CreditCardTransactionManager extends BaseTransactionManager {

	private static final String DEFAULT_REASON = "PAGAMENTO CARTA DI CREDITO";
	private static final String EUR_CURRENCY = "EUR";

	private static final Logger log = LoggerFactory.getLogger(CreditCardTransactionManager.class);

	private CreditCardTransactionManager() {
	}

	public static List<Transaction> buildTransactions(final String fileContent) throws Exception {
		final Body body = parseXml(fileContent);
		final Table table = body.getTable().get(0);
		final List<Transaction> transactions = new ArrayList<>();
		for (final Tr row : table.getTr()) {
			final String description = row.getTd().get(2).getContent();
			if (DESCRIPTION_HEADER.equals(description) || StringUtils.isEmpty(description.trim())) {
				continue;
			}
			final Transaction transaction = buildTransaction(row);
			log.debug(transaction.toString());
			transactions.add(transaction);
		}
		return transactions;
	}

	private static Transaction buildTransaction(final Tr row) {
		final String description = row.getTd().get(2).getContent();
		final Transaction transaction = new Transaction();
		transaction.setDescription(description);
		transaction.setCounterpart(CounterpartyPatternCache.getCounterparty(description));
		transaction.setValueDate(LocalDate.parse(row.getTd().get(0).getContent(), DATE_FORMATTER));
		transaction.setTransactionDateTime(transaction.getValueDate().atStartOfDay());
		transaction.setReason(DEFAULT_REASON);
		transaction.setCurrency(EUR_CURRENCY);
		final String currencyAmount = row.getTd().get(4).getContent().replace(',', '.');
		transaction.setCurrencyAmount(Double.valueOf(currencyAmount) * -1);
		return transaction;
	}

}
