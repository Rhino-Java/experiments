package test.example.db;

import java.util.Date;

import test.example.model.Employee;

public class DbConstants {

	public static final String DB_DRIVER = "org.h2.Driver";

	public static final String DATABASE_NAME = "emp";

	public static final String DB_USER = "h2";

	public static final String DB_PASSWORD = "abc@123";

	public static final String DB_DIR = "./database/";

	public static final String DB_CONNECTION_URL = "jdbc:h2:" + DB_DIR + DATABASE_NAME;

	public static final Employee[] employeeTableData = new Employee[] {
			new Employee("Bob", "Teacher", "male", "Academic", new Date()),
			new Employee("Alice", "Registrar", "female", "Admin", new Date()),
			new Employee("Rober", "Director", "male", "Management", new Date()) };
}
