package test.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.dbunit.database.IDatabaseConnection;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import test.example.dao.impl.CustomerDaoService;
import test.example.model.Customer;
import test.example.util.DatabaseUtil;

public class AppTest {

	protected static Connection connection;
	protected static IDatabaseConnection iDatabaseConnection;

	@BeforeClass
	public static void initialise() {
		try {
			connection = DatabaseUtil.createConnection();
			iDatabaseConnection = DatabaseUtil.createIDatabaseConnection(connection);
			DatabaseUtil.deleteOldDataAndImportXlsData(iDatabaseConnection, "./test_data/test_data.xls");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test() {
		try {
			List<Object> customers = new CustomerDaoService(connection).getData();
			Assert.assertFalse(customers.isEmpty());
			for (Object obj : customers) {
				Customer customer = (Customer) obj;
				System.out.println(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void baseDestroy() {
		try {
			connection.rollback();
			iDatabaseConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
