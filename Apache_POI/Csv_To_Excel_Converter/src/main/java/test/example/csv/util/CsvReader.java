package test.example.csv.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;

public class CsvReader {

	public static List<String[]> readCsv(String filePath) throws IOException {

		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			List<String[]> csvData = reader.readAll();
			return csvData;
		}
	}

}
