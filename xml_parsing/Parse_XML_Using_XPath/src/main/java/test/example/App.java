package test.example;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class App {

	public static void main(String[] args) {
		Parser parser = new Parser();
		try {
			parser.init();
			parser.printFirstnameOfAllEmployees();
			parser.printEmployeeDetailsWithId(2222);
			parser.printEmailAddressOfEmployeeWithId(3333);
			parser.printFirstnameOfAllAdminEmployees();
			parser.printFirstnameOfAllEmployeesOlderThan(40);
			parser.printFirstnameOfFirstTwoEmployees();
			parser.printFirstnameOfLastEmployee();
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			e.printStackTrace();
		}

	}

}
