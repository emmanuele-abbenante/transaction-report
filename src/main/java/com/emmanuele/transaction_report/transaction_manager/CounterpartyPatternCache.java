package com.emmanuele.transaction_report.transaction_manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import com.emmanuele.transaction_report.dao.CounterpartyPatternDao;
import com.emmanuele.transaction_report.model.CounterpartyPattern;

public class CounterpartyPatternCache {

	private static CounterpartyPatternCache instance = new CounterpartyPatternCache();
	private Map<String, String> patternsCounterpartiesMap = new HashMap<>();
	private List<Pattern> patterns = new ArrayList<>();

	private CounterpartyPatternCache() {
	}

	public static CounterpartyPatternCache getInstance() {
		return instance;
	}

	public void init(final DataSource dataSource) {
		CounterpartyPatternDao.getInstance().init(dataSource);
		final List<CounterpartyPattern> patterns = CounterpartyPatternDao
				.getInstance().selectAll();
		for (final CounterpartyPattern pattern : patterns) {
			instance.patternsCounterpartiesMap.put(pattern.getPattern(),
					pattern.getName());
			instance.patterns.add(Pattern.compile(pattern.getPattern()));
		}
	}

	public Map<String, String> getPatternsCounterpartiesMap() {
		return patternsCounterpartiesMap;
	}

	public List<Pattern> getPatterns() {
		return patterns;
	}

}
