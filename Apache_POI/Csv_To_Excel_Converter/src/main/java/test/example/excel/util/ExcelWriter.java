package test.example.excel.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

	public static void writeExcel(String filePath, List<String[]> excelData) throws IOException {
		String sheetName;
		if (!filePath.endsWith(".xlsx")) {
			sheetName = filePath.substring(filePath.lastIndexOf("/") + 1);
		} else {
			sheetName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length() - ".xlsx".length());
		}
		writeExcel(filePath, sheetName, excelData);
	}

	public static void writeExcel(String filePath, String sheetName, List<String[]> excelData) throws IOException {
		if (!filePath.endsWith(".xlsx")) {
			filePath = filePath + ".xlsx";
		}

		Workbook workbook = new XSSFWorkbook();
		Sheet worksheet = workbook.createSheet(sheetName);

		createDataRows(worksheet, excelData);
		FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
		workbook.write(fileOutputStream);
		fileOutputStream.close();
		workbook.close();

	}

	private static void createDataRows(Sheet worksheet, List<String[]> excelData) {
		Row row;
		Cell cell;
		for (int i = 0; i < excelData.size(); i++) {
			row = worksheet.createRow(i);

			for (int j = 0; j < excelData.get(i).length; j++) {
				cell = row.createCell(j);
				cell.setCellValue(excelData.get(i)[j]);
			}
		}
	}
}
