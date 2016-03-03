package test.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import test.example.regex.util.FileRegexHelper;

public class App {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filePath = "./input/sample.csv";
		boolean result = FileRegexHelper.isWordRegexExistInFile(filePath, "Bank\\s+statement");
		if (result) {
			System.out.println("\nWord \"Bank statement\" exist in the file.");
		} else {
			System.out.println("\nWord \"Bank statement\" does not exist in the file.");
		}
		int count = FileRegexHelper.getCountOfWordRegexInFile(filePath, "Bank\\s+Statement");
		System.out.println("\nWord \"Bank Statement\" exist " + count + " times in the file");

		List<String> matchedText = FileRegexHelper.getMatchedTextOfWordRegexInFile(filePath, "Bank\\s+Statement");
		System.out.println("\nWord \"Bank Statement\" has following occurrences -");
		for (String str : matchedText) {
			System.out.println(str);
		}
		String regex = "(?i)(.+?)(Bank\\s+statement)(.+?)";
		List<String[]> allMatchedText = FileRegexHelper.getAllMatchedTextOfWordRegexInFile(filePath, regex);
		System.out.println("\nDetails of occurrences of Regex \"" + regex + "\" -");
		count = 0;
		for (String[] stringArray : allMatchedText) {
			count++;
			System.out.println("Occurrence " + count + ":");
			for (String str : stringArray) {
				System.out.println(str);
			}
		}

	}
}
