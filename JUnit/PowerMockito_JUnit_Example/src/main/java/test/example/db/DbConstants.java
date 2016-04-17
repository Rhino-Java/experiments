package test.example.db;

public class DbConstants {

	public static final String DB_DRIVER = "org.h2.Driver";

	public static final String DATABASE_NAME = "banking";

	public static final String DB_USER = "h2";

	public static final String DB_PASSWORD = "abc@123";

	public static final String DB_DIR = "./database/";

	public static final String DB_CONNECTION_URL = "jdbc:h2:" + DB_DIR + DATABASE_NAME;

	public static final String DB_SCHEMA = "";

}
