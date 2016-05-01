package test.example;

import java.io.IOException;

import test.example.file.util.FileCopier;

public class App {
	public static void main(String[] args) throws IOException {
		FileCopier.copy("./input/abc.txt", "./output/xyz.txt");
		System.out.println("File has been copied");
	}
}
