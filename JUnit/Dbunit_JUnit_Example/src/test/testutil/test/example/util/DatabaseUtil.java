package test.example.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.operation.DatabaseOperation;

import test.example.db.DbConstants;

public class DatabaseUtil {

	public static Connection createConnection() throws Exception {

		try {
			Class.forName(DbConstants.DB_DRIVER);
			Connection connection = DriverManager.getConnection(DbConstants.DB_CONNECTION_URL, DbConstants.DB_USER,
					DbConstants.DB_PASSWORD);
			connection.setAutoCommit(false);

			return connection;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static IDatabaseConnection createIDatabaseConnection(Connection connection) throws Exception {
		IDatabaseConnection iDatabaseConnection = new DatabaseConnection(connection, DbConstants.DB_SCHEMA);
		return iDatabaseConnection;
	}

	public static void deleteOldDataAndImportXlsData(IDatabaseConnection iDatabaseConnection, String xlsFilePath)
			throws Exception {
		IDataSet dataSet = new XlsDataSet(new FileInputStream(new File(xlsFilePath)));
		DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);
	}

	public static void importXlsData(IDatabaseConnection iDatabaseConnection, String xlsFilePath) throws Exception {
		IDataSet dataSet = new XlsDataSet(new FileInputStream(new File(xlsFilePath)));
		DatabaseOperation.INSERT.execute(iDatabaseConnection, dataSet);
	}

	public static void deleteOldData(IDatabaseConnection iDatabaseConnection) throws Exception {
		IDataSet dataSet = new DefaultDataSet();
		DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection, dataSet);
	}
}
