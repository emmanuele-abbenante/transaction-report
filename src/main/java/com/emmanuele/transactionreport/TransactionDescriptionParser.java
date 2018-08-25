package com.emmanuele.transactionreport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionDescriptionParser {

	private static final String NOT_ALLOWED_CHARACTERS_REGEX = "[^a-zA-Z0-9\\/:=\\.\\-\\s]";

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
			.ofPattern("dd/MM/yyyy HH:mm");

	private static final Pattern VPAY_OPERATION = Pattern
			.compile("Operazione VPAY del (?<date>.*) alle ore (?<time>.*) con Carta[ \t\n]*(?<cardnumber>.*) Div=(?<currency>.*) Importo in divisa=(?<currencyamount>.*) \\/ Importo in Euro=(?<euramount>.*)[ \t\n]*presso (?<counterpart>.*) - Transazione C-less");

	private TransactionDescriptionParser() {
	}

	public static Transaction parseDescription(final String description) {
		final Transaction transaction = new Transaction();
		final String cleanedDescriptionStr = description.replaceAll(
				NOT_ALLOWED_CHARACTERS_REGEX, "");
		final Matcher matcher = VPAY_OPERATION.matcher(cleanedDescriptionStr);
		if (matcher.matches()) {
			return parseVPayOperationDescription(matcher);
		}
		return transaction;
	}

	private static Transaction parseVPayOperationDescription(
			final Matcher matcher) {
		final Transaction transaction = new Transaction();
		final String dateTimeStr = matcher.group("date") + " "
				+ matcher.group("time");
		transaction.setTransactionDateTime(LocalDateTime.parse(dateTimeStr,
				DATE_TIME_FORMATTER));
		transaction.setCardNumber(matcher.group("cardnumber"));
		transaction.setCurrency(matcher.group("currency"));
		final String currencyAmount = matcher.group("currencyamount");
		if (currencyAmount != null) {
			transaction.setCurrencyAmount(Double.valueOf(currencyAmount));
		}
		final String eurAmount = matcher.group("euramount");
		if (eurAmount != null) {
			transaction.setEurAmount(Double.valueOf(eurAmount));
		}
		transaction.setCounterpart(matcher.group("counterpart"));
		return transaction;
	}

}
