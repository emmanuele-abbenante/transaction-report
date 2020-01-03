package com.emmanuele.transaction_report.transaction_manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.emmanuele.transaction_report.App;
import com.emmanuele.transaction_report.utils.FileUtils;

public class CounterpartyPatternCache {

	private static final String PROPERTIES_FILE = "counterparties_patterns.properties";
	private static final String PATTERNS_PROPERTY = "counterparties_patterns";

	private static final String COLON_SEPARATOR = ":";
	private static final String PIPE_SEPARATOR = "\\|";

	private static final Map<Pattern, String> PATTERNS = new HashMap<>();
	static {
		try {
			final Properties properties = FileUtils.readExternalProperties(App.class, PROPERTIES_FILE);
			for (final String entry : properties.getProperty(PATTERNS_PROPERTY).split(PIPE_SEPARATOR)) {
				final String[] items = entry.split(COLON_SEPARATOR);
				final String pattern = items[0];
				String counterparty = items[1];
				PATTERNS.put(Pattern.compile(pattern), counterparty);
			}
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static CounterpartyPatternCache instance = new CounterpartyPatternCache();

	private CounterpartyPatternCache() {
	}

	public static CounterpartyPatternCache getInstance() {
		return instance;
	}

	public static String getCounterparty(final String description) {
		String counterparty = description;
		for (final Pattern pattern : PATTERNS.keySet()) {
			final Matcher matcher = pattern.matcher(description);
			if (matcher.matches()) {
				counterparty = PATTERNS.get(pattern);
				break;
			}
		}
		return counterparty;
	}

}
