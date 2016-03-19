package test.example;

import java.io.FileNotFoundException;
import java.io.IOException;

import test.example.file.util.TextReaderUtil;

public class App {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		String fileContent = TextReaderUtil.getFileContentAsString("./input/sample.csv");
		System.out.println("File content is printed below -");
		System.out.print(fileContent);
	}
}
