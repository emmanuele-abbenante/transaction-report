package com.emmanuele.transaction_report.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtils {

	private FileUtils() {
	}

	public static String readFile(final String filePath) throws IOException {
		final StringBuilder transactionsFileStr = new StringBuilder();
		try (final FileReader fr = new FileReader(filePath);
				final BufferedReader br = new BufferedReader(fr);) {
			String line;
			while ((line = br.readLine()) != null) {
				transactionsFileStr.append(line);
			}
		}
		return transactionsFileStr.toString();
	}

	public static Properties readProperties(final Class<?> classObject,
			final String fileName) throws IOException {
		try (InputStream is = classObject.getClassLoader().getResourceAsStream(
				fileName)) {
			final Properties properties = new Properties();
			properties.load(is);
			return properties;
		}
	}

}
