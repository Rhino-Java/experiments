package test.example;

import java.io.File;
import java.io.IOException;

import test.example.util.BinaryWriter;

public class App {
	public static void main(String[] args) throws IOException {

		byte temp[] = "Hello Test".getBytes("UTF-8");
		String filePath = "./output/test.txt";
		File file = BinaryWriter.writeByteArrayToFile(filePath, temp);
		System.out.println(file.getCanonicalPath() + " is created.");
	}
}
