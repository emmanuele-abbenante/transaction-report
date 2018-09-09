package com.emmanuele.transaction_report.model;

public class CounterpartyPattern {

	private String pattern;
	private String name;

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CounterpartyPattern [pattern=" + pattern + ", name=" + name
				+ "]";
	}

}
