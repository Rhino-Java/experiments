package test.example.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TextReaderUtil {

	private static final String DEFAULT_ENCODING = "UTF-8";

	public static String getInputStreamContentAsString(InputStream inputStream, String fileEncoding)
			throws FileNotFoundException, IOException {
		StringBuilder text = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		try (Scanner scanner = new Scanner(inputStream, fileEncoding)) {
			boolean isFirstLine = true;
			while (scanner.hasNextLine()) {
				if (isFirstLine) {
					text.append(scanner.nextLine());
					isFirstLine = false;
				} else {
					text.append(newLine).append(scanner.nextLine());
				}
			}
		}
		return text.toString();
	}

	public static String getFileContentAsString(String filePath, String fileEncoding)
			throws FileNotFoundException, IOException {
		return getInputStreamContentAsString(new FileInputStream(filePath), fileEncoding);
	}

	public static String getFileContentAsString(String filePath) throws FileNotFoundException, IOException {
		return getInputStreamContentAsString(new FileInputStream(filePath), DEFAULT_ENCODING);
	}

	public static String getInputStreamContentAsString(InputStream inputStream)
			throws FileNotFoundException, IOException {
		return getInputStreamContentAsString(inputStream, DEFAULT_ENCODING);
	}
}