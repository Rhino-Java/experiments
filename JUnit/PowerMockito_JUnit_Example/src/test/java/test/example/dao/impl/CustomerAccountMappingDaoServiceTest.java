package test.example.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import test.example.db.DbQueries;
import test.example.model.CustomerAccountMapping;

public class CustomerAccountMappingDaoServiceTest {

	private Connection connection;

	private Statement statement;

	private ResultSet resultSet;

	@Before
	public void setUp() throws SQLException {
		connection = Mockito.mock(Connection.class);
		statement = Mockito.mock(Statement.class);
		resultSet = Mockito.mock(ResultSet.class);
		Mockito.when(connection.createStatement()).thenReturn(statement);
		Mockito.when(statement.executeQuery(DbQueries.SELECT_CUSTOMER_ACCOUNT_MAPPING_TABLE)).thenReturn(resultSet);
		Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
		Mockito.when(resultSet.getInt("id")).thenReturn(101);
		Mockito.when(resultSet.getString("customerid")).thenReturn("23FEFE829MF");
		Mockito.when(resultSet.getString("accountno")).thenReturn("000011111111");

	}

	@Test
	public void createTableTest() throws Exception {
		CustomerAccountMappingDaoService customerAccountMappingDaoService = new CustomerAccountMappingDaoService(
				connection);
		customerAccountMappingDaoService.createTable();
	}

	@Test
	public void insertTest() throws Exception {
		CustomerAccountMappingDaoService customerAccountMappingDaoService = new CustomerAccountMappingDaoService(
				connection);
		customerAccountMappingDaoService.insert(getCustomerAccountMapping());
	}

	@Test
	public void getDataTest() throws Exception {
		CustomerAccountMappingDaoService customerAccountMappingDaoService = new CustomerAccountMappingDaoService(
				connection);
		List<Object> customerAccountMappingDataList = customerAccountMappingDaoService.getData();
		for (Object obj : customerAccountMappingDataList) {
			CustomerAccountMapping customerAccountMapping = (CustomerAccountMapping) obj;
			System.out.println(customerAccountMapping);
		}
	}

	private CustomerAccountMapping getCustomerAccountMapping() {
		CustomerAccountMapping customerAccountMapping = new CustomerAccountMapping(101, "23FEFE829MF", "000011111111");
		return customerAccountMapping;
	}

}
