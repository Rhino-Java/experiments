package test.example.db;

public class DbQueries {

	public static final String CREATE_EMP_TABLE = "CREATE TABLE Employee(empid INT PRIMARY KEY AUTO_INCREMENT, empname VARCHAR(200), occupation VARCHAR(100), gender VARCHAR (6), department VARCHAR(100), dateofbirth DATE)";

	public static final String INSERT_EMP_TABLE = "INSERT INTO Employee(empname, occupation, gender, department, dateofbirth) VALUES ('%s','%s', '%s', '%s', '%s')";

	public static final String SELECT_EMP_TABLE = "SELECT * FROM Employee";

	public static final String PREPARED_INSERT_EMP_TABLE = "INSERT INTO Employee(empname, occupation, gender, department, dateofbirth) VALUES (?,?, ?, ?, ?)";

	public static final String DELETE_EMP_TABLE = "DELETE FROM Employee";

	public static final String UPDATE_EMP_TABLE = "UPDATE Employee SET department='%s'";

}
