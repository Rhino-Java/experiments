package test.example;

import java.io.IOException;
import java.util.List;

import test.example.csv.util.CsvReader;
import test.example.excel.util.ExcelWriter;

public class App {

	public static void main(String[] args) throws IOException {

		List<String[]> excelData = CsvReader.readCsv("./input/sample.csv");

		ExcelWriter.writeExcel("./output/sample", excelData);

		System.out.println("Excel report has been generated.");
	}
}
