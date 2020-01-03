package com.emmanuele.transaction_report.transaction_manager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.emmanuele.transaction_report.App;
import com.emmanuele.transaction_report.model.Transaction;
import com.emmanuele.transaction_report.utils.FileUtils;

public class CurrentAccountTransactionDescriptionParser {

	private static final String PROPERTIES_FILE = "curr_acc_trans_desc_patterns.properties";
	private static final String PATTERNS_PROPERTY = "curr_acc_trans_desc_patterns";
	private static final String NOT_ALLOWED_CHARACTERS_REGEX = "[^a-zA-Z0-9\\/:=\\.\\-\\s,&]";
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	private static final String SEMICOLON_SEPARATOR = ";";
	private static final String PIPE_SEPARATOR = "\\|";
	private static final String HASH_SEPARATOR = "#";

	// Using a LinkedHashMap because the insertion order is meaningful.
	// The patterns are specified into the properties according to their priorities.
	private static final Map<Pattern, String[]> PATTERNS = new LinkedHashMap<>();
	static {
		try {
			final Properties properties = FileUtils.readExternalProperties(App.class, PROPERTIES_FILE);
			for (final String entry : properties.getProperty(PATTERNS_PROPERTY).split(HASH_SEPARATOR)) {
				final String[] items = entry.split(PIPE_SEPARATOR);
				final String patternStr = items[0];
				String fields = null;
				if (items.length == 2) {
					fields = items[1];
				}
				PATTERNS.put(Pattern.compile(patternStr), fields != null ? fields.split(SEMICOLON_SEPARATOR) : null);
			}
		} catch (final Exception e) {
			throw new RuntimeException(e);
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
