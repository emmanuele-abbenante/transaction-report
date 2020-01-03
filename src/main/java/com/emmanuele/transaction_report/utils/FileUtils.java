package com.emmanuele.transaction_report.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;

public class FileUtils {

	private FileUtils() {
	}

	public static String readFile(final String filePath) throws IOException {
		final StringBuilder transactionsFileStr = new StringBuilder();
		try (final FileReader fr = new FileReader(filePath); final BufferedReader br = new BufferedReader(fr);) {
			String line;
			while ((line = br.readLine()) != null) {
				transactionsFileStr.append(line);
			}
		}
		return transactionsFileStr.toString();
	}

	public static Properties readProperties(final Class<?> classObject, final String fileName) throws IOException {
		try (InputStream is = classObject.getClassLoader().getResourceAsStream(fileName)) {
			final Properties properties = new Properties();
			properties.load(is);
			return properties;
		}
	}

	public static Properties readExternalProperties(final Class<?> classObject, final String fileName)
			throws IOException, URISyntaxException {
		final String filePath = FilenameUtils.getFullPath(
				new File(classObject.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath());
		try (InputStream is = new FileInputStream(filePath + fileName)) {
			final Properties properties = new Properties();
			properties.load(is);
			return properties;
		}
	}

	public static Properties readExternalProperties(final Class<?> classObject, final String filePath,
			final String fileName) throws IOException {
		try (InputStream is = new FileInputStream(filePath + fileName)) {
			final Properties properties = new Properties();
			properties.load(is);
			return properties;
		}
	}

}
