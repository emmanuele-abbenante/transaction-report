package com.emmanuele.transaction_report.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {

	private LocalDateTime transactionDateTime;
	private LocalDate valueDate;
	private String reason;
	private String description;
	private String currency;
	private Double currencyAmount;
	private String cardNumber;
	private Double eurAmount;
	private String counterpart;
	private String atmName;
	private String counterpartIban;
	private String paymentReason;
	private String foreignCurrency;
	private Double exchangeRate;

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public LocalDate getValueDate() {
		return valueDate;
	}

	public void setValueDate(LocalDate valueDate) {
		this.valueDate = valueDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getCurrencyAmount() {
		return currencyAmount;
	}

	public void setCurrencyAmount(Double currencyAmount) {
		this.currencyAmount = currencyAmount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Double getEurAmount() {
		return eurAmount;
	}

	public void setEurAmount(Double eurAmount) {
		this.eurAmount = eurAmount;
	}

	public String getCounterpart() {
		return counterpart;
	}

	public void setCounterpart(String counterpart) {
		this.counterpart = counterpart;
	}

	public String getAtmName() {
		return atmName;
	}

	public void setAtmName(String atmName) {
		this.atmName = atmName;
	}

	public String getCounterpartIban() {
		return counterpartIban;
	}

	public void setCounterpartIban(String counterpartIban) {
		this.counterpartIban = counterpartIban;
	}

	public String getPaymentReason() {
		return paymentReason;
	}

	public void setPaymentReason(String paymentReason) {
		this.paymentReason = paymentReason;
	}

	public String getForeignCurrency() {
		return foreignCurrency;
	}

	public void setForeignCurrency(String foreignCurrency) {
		this.foreignCurrency = foreignCurrency;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	@Override
	public String toString() {
		return "Transaction [transactionDateTime=" + transactionDateTime
				+ ", valueDate=" + valueDate + ", reason=" + reason
				+ ", description=" + description + ", currency=" + currency
				+ ", currencyAmount=" + currencyAmount + ", cardNumber="
				+ cardNumber + ", eurAmount=" + eurAmount + ", counterpart="
				+ counterpart + ", atmName=" + atmName + ", counterpartIban="
				+ counterpartIban + ", paymentReason=" + paymentReason
				+ ", foreignCurrency=" + foreignCurrency + ", exchangeRate="
				+ exchangeRate + "]";
	}

}
