package test.example;

import java.io.IOException;

import test.example.jar.util.JarExtractor;

public class App {
	public static void main(String[] args) throws IOException {
		JarExtractor.extract("./input/Jasper_Report_Example-1.0-SNAPSHOT.jar", "./output/");
		System.out.println("JAR file has been extracted.");
	}
}
