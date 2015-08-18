package test.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	Document document;
	XPath xPath;

	public void init() throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		/*
		 * Parse the xml file
		 */
		document = builder.parse(new FileInputStream("xml/employees.xml"));
		/*
		 * If xml file content is present in a string name 'xmlString', use
		 * following line for creating Document object -
		 */
		// Document xmlDocument = builder.parse(new
		// ByteArrayInputStream(xmlString.getBytes()));
		xPath = XPathFactory.newInstance().newXPath();
	}

	public void printFirstnameOfAllEmployees() throws XPathExpressionException {
		String expression = "/Employees/Employee/firstname";
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
		System.out.println("First name of all employees are -");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
		}
	}

	public void printEmployeeDetailsWithId(int emplId) throws XPathExpressionException {
		String expression = "/Employees/Employee[@emplid='" + emplId + "']";
		System.out.println("Details of the Employeed having id " + emplId + " -");
		Node node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);
		if (null != node) {
			NodeList nodeList = node.getChildNodes();
			for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
				Node nod = nodeList.item(i);
				if (nod.getNodeType() == Node.ELEMENT_NODE)
					System.out.println(nodeList.item(i).getNodeName() + " : " + nod.getFirstChild().getNodeValue());
			}
		}
	}

	public void printEmailAddressOfEmployeeWithId(int emplId) throws XPathExpressionException {
		String expression = "/Employees/Employee[@emplid='" + emplId + "']/email";
		// read a string value
		String email = xPath.compile(expression).evaluate(document);
		System.out.println("email address of the employee with id " + emplId + " is " + email);
	}

	public void printFirstnameOfAllAdminEmployees() throws XPathExpressionException {
		String expression = "/Employees/Employee[@type='admin']/firstname";
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
		System.out.println("First name of all employees who are admin are -");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
		}
	}

	public void printFirstnameOfAllEmployeesOlderThan(int age) throws XPathExpressionException {
		String expression = "/Employees/Employee[age>" + age + "]/firstname";
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
		System.out.println("First name of all employees who are older than " + age + " are -");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
		}
	}

	public void printFirstnameOfFirstTwoEmployees() throws XPathExpressionException {
		// filter employees using position(), index starts from 1
		String expression = "/Employees/Employee[position() <= 2 ]/firstname";
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
		System.out.println("First name of first 2 employees are -");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
		}
	}

	public void printFirstnameOfLastEmployee() throws XPathExpressionException {
		String expression = "/Employees/Employee[last()]/firstname";
		String firstName = (String) xPath.compile(expression).evaluate(document, XPathConstants.STRING);
		System.out.println("First name of last employee is - " + firstName);
	}
}