package test.example.db;

import java.io.File;
import java.util.Date;

import test.example.model.Employee;

public class DbConstants {

	public static final String DB_DRIVER = "org.h2.Driver";

	public static final String DB_NAME = "emp";

	public static final String DB_USER = "h2";

	public static final String DB_PASSWORD = "abc@123";

	public static final String DB_DIR = getDatabaseDirectory();

	public static final String DB_SERVER_ADDRESS = "127.0.0.1";

	public static final String H2_DATABASE_DEFAULT_PORT = "9092";

	public static final String DB_SERVER_PORT = H2_DATABASE_DEFAULT_PORT;

	public static final String DB_CONNECTION_URL = "jdbc:h2:tcp://" + DB_SERVER_ADDRESS + ":" + DB_SERVER_PORT + "/"
			+ DB_DIR + DB_NAME;

	public static final String DB_MAPPER_PACKAGE = "test.example.db.dao";

	public static final Employee[] employeeTableData = new Employee[] {
			new Employee(0, "Bob", "Teacher", "male", "Academic", new Date()),
			new Employee(0, "Alice", "Registrar", "female", "Admin", new Date()),
			new Employee(0, "Rober", "Director", "male", "Management", new Date()) };

	private static String getDatabaseDirectory() {
		String filePath = DbConstants.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		filePath = new File(filePath).getParentFile().getParent() + File.separator + "database" + File.separator;
		System.out.println(filePath);
		return filePath;
	}

}
