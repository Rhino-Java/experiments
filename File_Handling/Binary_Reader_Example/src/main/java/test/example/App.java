package test.example;

import java.io.FileNotFoundException;
import java.io.IOException;

import test.example.file.util.BinaryReader;

public class App {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		byte[] fileContent = BinaryReader.getFileContentAsByteArray("./input/sample.csv");
		System.out.println("File content is printed below -");
		System.out.print(new String(fileContent, "UTF-8"));
	}
}
