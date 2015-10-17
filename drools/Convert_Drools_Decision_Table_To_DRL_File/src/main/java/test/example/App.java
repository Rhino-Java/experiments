package test.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;

public class App {

	private static final String DECISION_TABLE_PATH = ".\\Input_files\\test_rules.xls";

	public static void main(String[] args) throws FileNotFoundException {

		// create an input stream
		// assign the excel to the input stream
		// mention the local directory path where the excel is kept
		InputStream inputStream = new FileInputStream(DECISION_TABLE_PATH);

		// create compiler class instance
		SpreadsheetCompiler spreadsheetCompiler = new SpreadsheetCompiler();
		// compile the excel to generate the (.drl) file
		String drl = spreadsheetCompiler.compile(inputStream, InputType.XLS);
		// check the generated (.drl) file
		System.out.println("Generate DRL file is –:\n");
		System.out.println(drl);
	}
}