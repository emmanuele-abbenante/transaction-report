package com.emmanuele.transaction_report.transaction_manager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.emmanuele.transaction_report.dao.CurrentAccountTransactionPatternDao;
import com.emmanuele.transaction_report.model.CurrentAccountTransactionPattern;
import com.emmanuele.transaction_report.model.Transaction;

public class CurrentAccountTransactionDescriptionParser {

	private static final String NOT_ALLOWED_CHARACTERS_REGEX = "[^a-zA-Z0-9\\/:=\\.\\-\\s,&]";
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	private static final String SEMICOLON_SEPARATOR = ";";

	private static final Map<Pattern, String[]> PATTERNS = new HashMap<>();
	static {
		final List<CurrentAccountTransactionPattern> patterns = CurrentAccountTransactionPatternDao.getInstance()
				.selectAll();
		for (final CurrentAccountTransactionPattern pattern : patterns) {
			final String fields = pattern.getFields();
			PATTERNS.put(Pattern.compile(pattern.getPattern()),
					fields != null ? fields.split(SEMICOLON_SEPARATOR) : null);
		}
	}

	private CurrentAccountTransactionDescriptionParser() {
	}

	public static Transaction parseDescription(final String description) {
		final String cleanedDescriptionStr = description.replaceAll(NOT_ALLOWED_CHARACTERS_REGEX, "");

		String[] fields = null;
		Matcher matcher = null;
		boolean matchFound = false;
		for (final Entry<Pattern, String[]> entry : PATTERNS.entrySet()) {
			matcher = entry.getKey().matcher(cleanedDescriptionStr);
			if (matcher.matches()) {
				matchFound = true;
				fields = entry.getValue();
				break;
			}
		}

		if (!matchFound) {
			throw new IllegalArgumentException("Unknown description: " + description);
		}

		final Transaction transaction = new Transaction();
		if (fields != null) {
			for (final String field : fields) {
				switch (field) {
				case "date":
					final String dateTimeStr = matcher.group("date") + " " + matcher.group("time");
					transaction.setTransactionDateTime(LocalDateTime.parse(dateTimeStr, DATE_TIME_FORMATTER));
					break;
				case "cardnumber":
					transaction.setCardNumber(matcher.group("cardnumber"));
					break;
				case "currency":
					transaction.setCurrency(matcher.group("currency"));
					break;
				case "currencyamount":
					final String currencyAmount = matcher.group("currencyamount");
					if (currencyAmount != null) {
						transaction.setCurrencyAmount(Double.valueOf(currencyAmount));
					}
					break;
				case "euramount":
					final String eurAmount = matcher.group("euramount");
					if (eurAmount != null) {
						transaction.setEurAmount(Double.valueOf(eurAmount));
					}
					break;
				case "counterpart":
					final String counterpart = matcher.group("counterpart");
					if (counterpart != null) {
						transaction.setCounterpart(counterpart.trim());
					}
					break;
				case "foreignCurrency":
					transaction.setForeignCurrency(matcher.group("foreignCurrency"));
					break;
				case "exchangeRate":
					final String exchangeRate = matcher.group("exchangeRate").replace(',', '.');
					if (exchangeRate != null) {
						transaction.setExchangeRate(Double.valueOf(exchangeRate));
					}
					break;
				case "counterpartiban":
					transaction.setCounterpartIban(matcher.group("counterpartiban"));
					break;
				case "paymentreason":
					transaction.setPaymentReason(matcher.group("paymentreason"));
					break;
				default:
				}
			}
		}
		return transaction;
	}

}
