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
	private static final Pattern WITHDRAWAL_OPERATION = Pattern
			.compile("Prelievo carta del (?<date>.*) alle ore (?<time>.*) con Carta[ \t\n]*(?<cardnumber>.*) di Abi Div=(?<currency>.*) Importo in divisa=(?<currencyamount>.*) / Importo in[ \t\n]*Euro=(?<euramount>.*) presso (?<counterpart>.*)");
	private static final Pattern CREDIT_CARD_FEE_OPERATION = Pattern
			.compile("Canone mensile Carta di Credito");
	private static final Pattern MONEY_TRANSFER_OPERATION = Pattern
			.compile("DA .* Giroconto");
	private static final Pattern CREDIT_CARD_CHARGE_OPERATION = Pattern
			.compile(".* ADDEBITO CARTA CREDITO .* E\\/C AL .* COD\\.CLIENTE: .*");
	private static final Pattern PAYMENT_OPERATION = Pattern
			.compile("BONIFICO DA VOI DISPOSTO NOP .* A FAVORE DI (?<counterpart>.*) C. BENEF. (?<counterpartiban>.*) NOTE: (?<paymentreason>.*)");

	private TransactionDescriptionParser() {
	}

	public static Transaction parseDescription(final String description) {
		final String cleanedDescriptionStr = description.replaceAll(
				NOT_ALLOWED_CHARACTERS_REGEX, "");
		Matcher matcher = VPAY_OPERATION.matcher(cleanedDescriptionStr);
		if (matcher.matches()) {
			return parseVPayOperationDescription(matcher);
		}
		matcher = WITHDRAWAL_OPERATION.matcher(cleanedDescriptionStr);
		if (matcher.matches()) {
			return parseVPayOperationDescription(matcher);
		}
		matcher = CREDIT_CARD_FEE_OPERATION.matcher(cleanedDescriptionStr);
		if (matcher.matches()) {
			return parseGenericDescription(matcher);
		}
		matcher = MONEY_TRANSFER_OPERATION.matcher(cleanedDescriptionStr);
		if (matcher.matches()) {
			return parseGenericDescription(matcher);
		}
		matcher = CREDIT_CARD_CHARGE_OPERATION.matcher(cleanedDescriptionStr);
		if (matcher.matches()) {
			return parseGenericDescription(matcher);
		}
		matcher = PAYMENT_OPERATION.matcher(cleanedDescriptionStr);
		if (matcher.matches()) {
			return parsePaymentOperationDescription(matcher);
		}
		throw new IllegalArgumentException("Unknown description: "
				+ description);
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

	private static Transaction parsePaymentOperationDescription(
			final Matcher matcher) {
		final Transaction transaction = new Transaction();
		transaction.setCounterpart(matcher.group("counterpart"));
		transaction.setCounterpartIban(matcher.group("counterpartiban"));
		transaction.setPaymentReason(matcher.group("paymentreason"));
		return transaction;
	}

	private static Transaction parseGenericDescription(final Matcher matcher) {
		final Transaction transaction = new Transaction();
		return transaction;
	}

}