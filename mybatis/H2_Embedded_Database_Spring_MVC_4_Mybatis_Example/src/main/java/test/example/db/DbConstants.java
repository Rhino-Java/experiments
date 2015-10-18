package test.example.db;

import java.util.Date;

import test.example.model.Employee;

public class DbConstants {

	public static final Employee[] employeeTableData = new Employee[] {
			new Employee(0, "Bob", "Teacher", "male", "Academic", new Date()),
			new Employee(0, "Alice", "Registrar", "female", "Admin", new Date()),
			new Employee(0, "Rober", "Director", "male", "Management", new Date()) };

	public static final String DATABASE_NAME = "emp";

	public static final String DB_DIR = "./database/";

}
