package test.example.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import test.example.db.DbConstants;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName(DbConstants.DB_DRIVER);

		Connection connection = DriverManager.getConnection(DbConstants.DB_CONNECTION_URL, DbConstants.DB_USER,
				DbConstants.DB_PASSWORD);

		connection.setAutoCommit(false);

		return connection;
	}

}
