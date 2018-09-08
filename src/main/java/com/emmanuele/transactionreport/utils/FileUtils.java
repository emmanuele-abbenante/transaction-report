package com.emmanuele.transactionreport.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

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

}
