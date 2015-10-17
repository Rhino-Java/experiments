package test.example.db;

public class DbQueries {

	public static final String CREATE_EMP_TABLE = "CREATE TABLE Employee(empid int primary key auto_increment, empname varchar(200), occupation varchar(100), gender varchar (6), department varchar(100), dateofbirth date)";

	public static final String INSERT_EMP_TABLE = "INSERT INTO Employee(empname, occupation, gender, department, dateofbirth) VALUES ('%s','%s', '%s', '%s', '%s')";

	public static final String SELECT_EMP_TABLE = "SELECT * FROM Employee";

	public static final String PREPARED_INSERT_EMP_TABLE = "INSERT INTO Employee(empname, occupation, gender, department, dateofbirth) VALUES (?,?, ?, ?, ?)";

	public static final String DELETE_EMP_TABLE = "DELETE FROM Employee";

	public static final String UPDATE_EMP_TABLE = "UPDATE Employee set department='%s'";

}
