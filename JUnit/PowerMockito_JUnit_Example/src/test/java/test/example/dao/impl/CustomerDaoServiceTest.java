package test.example.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import test.example.db.DbQueries;
import test.example.model.Customer;

public class CustomerDaoServiceTest {

	private Connection connection;

	private Statement statement;

	private ResultSet resultSet;

	@Before
	public void setUp() throws SQLException {
		connection = Mockito.mock(Connection.class);
		statement = Mockito.mock(Statement.class);
		resultSet = Mockito.mock(ResultSet.class);
		Mockito.when(connection.createStatement()).thenReturn(statement);
		Mockito.when(statement.executeQuery(DbQueries.SELECT_CUSTOMER_TABLE)).thenReturn(resultSet);
		Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
		Mockito.when(resultSet.getString("id")).thenReturn("23FEFE829MF");
		Mockito.when(resultSet.getString("name")).thenReturn("Bob");
		Mockito.when(resultSet.getString("gender")).thenReturn("Male");
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(1882, 11, 2);
		Mockito.when(resultSet.getDate("dateofbirth")).thenReturn(new Date(dateOfBirth.getTimeInMillis()));
		Mockito.when(resultSet.getString("occupation")).thenReturn("Student");
		Mockito.when(resultSet.getString("city")).thenReturn("New York");
		Mockito.when(resultSet.getString("mobileNo")).thenReturn("9174944476");
		Mockito.when(resultSet.getString("address")).thenReturn("445 Fifth Avenue, Suite 32D, New York, N.Y. 10016");

	}

	@Test
	public void createTableTest() throws Exception {
		CustomerDaoService customerDaoService = new CustomerDaoService(connection);
		customerDaoService.createTable();
	}

	@Test
	public void insertTest() throws Exception {
		CustomerDaoService customerDaoService = new CustomerDaoService(connection);
		customerDaoService.insert(getCustomer());
	}

	@Test
	public void getDataTest() throws Exception {
		CustomerDaoService customerDaoService = new CustomerDaoService(connection);
		List<Object> customerDataList = customerDaoService.getData();
		for (Object obj : customerDataList) {
			Customer customer = (Customer) obj;
			System.out.println(customer);
		}
	}

	private Customer getCustomer() {
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(1882, 11, 2);
		Customer customer = new Customer("23FEFE829MF", "Bob", "Male", dateOfBirth.getTime(), "Student", "New York",
				"9174944476", "445 Fifth Avenue, Suite 32D, New York, N.Y. 10016");
		return customer;
	}

}
