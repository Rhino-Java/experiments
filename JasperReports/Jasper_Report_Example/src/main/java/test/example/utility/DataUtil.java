package test.example.utility;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import test.example.exception.ErrorCodes;
import test.example.exception.ErrorMessages;
import test.example.exception.SampleJasperException;
import test.example.model.Transaction;

public class DataUtil {

	public static List<Transaction> getSampleData() {
		List<Transaction> transactionList = new ArrayList<>();
		validateDataCsvFilePath();
		try {
			List<String> lines = Files.readAllLines(Paths.get(Constants.DATA_CSV_FILE_PATH),
					Charset.forName(Constants.DATA_CSV_ENCODING));
			for (String line : lines) {
				String[] splittedData = line.split(",");
				Transaction transaction = new Transaction(splittedData[0], splittedData[1], splittedData[2],
						splittedData[3], splittedData[4], splittedData[5], splittedData[6], splittedData[7],
						splittedData[8], splittedData[9]);
				transactionList.add(transaction);
			}
		} catch (IOException exception) {
			throw new SampleJasperException(ErrorCodes.INPUT_CSV_FILE_ERROR + ":" + ErrorMessages.ERROR_MSG_7);
		}
		return transactionList;
	}

	private static void validateDataCsvFilePath() {
		if (!CommonUtil.isFilePathValid(Constants.DATA_CSV_FILE_PATH)) {
			throw new SampleJasperException(ErrorCodes.INPUT_CSV_NOT_FOUND + ":" + ErrorMessages.ERROR_MSG_6);
		}
	}
}