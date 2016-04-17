package test.example.db;

public class DbQueries {

	public static final String CREATE_CUSTOMER_TABLE = "CREATE TABLE customer(id VARCHAR(20) PRIMARY KEY, name VARCHAR(200), gender VARCHAR (6), dateofbirth DATE, occupation VARCHAR(200), city VARCHAR (100) , mobileNo VARCHAR(10), address VARCHAR(200))";

	public static final String CREATE_ACCOUNT_TABLE = "CREATE TABLE account (accountno VARCHAR(20) PRIMARY KEY, accounttype VARCHAR(200), balance BIGINT)";

	public static final String CREATE_CUSTOMER_ACCOUNT_MAPPING_TABLE = "CREATE TABLE customer_account_mapping (id INT PRIMARY KEY, customerid VARCHAR(20) ,accountno VARCHAR(20), FOREIGN KEY (customerid) REFERENCES customer(id), FOREIGN KEY (accountno) REFERENCES account(accountno))";

	public static final String INSERT_CUSTOMER_TABLE = "INSERT INTO customer(id, name, gender, dateofbirth , occupation , city , mobileNo , address ) VALUES ('%s','%s', '%s', '%s', '%s' , '%s', '%s', '%s')";

	public static final String INSERT_ACCOUNT_TABLE = "INSERT INTO account (accountno , accounttype , balance) VALUES ('%s','%s', '%s')";

	public static final String INSERT_CUSTOMER_ACCOUNT_MAPPING_TABLE = "INSERT INTO customer_account_mapping (id , customerid , accountno) VALUES ('%s','%s', '%s')";

	public static final String SELECT_CUSTOMER_TABLE = "SELECT * FROM customer";

	public static final String SELECT_ACCOUNT_TABLE = "SELECT * FROM account";

	public static final String SELECT_CUSTOMER_ACCOUNT_MAPPING_TABLE = "SELECT * FROM customer_account_mapping";

}
