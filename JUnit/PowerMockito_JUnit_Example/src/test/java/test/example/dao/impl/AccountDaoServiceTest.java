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
import test.example.model.Account;

public class AccountDaoServiceTest {

	private Connection connection;

	private Statement statement;

	private ResultSet resultSet;

	@Before
	public void setUp() throws SQLException {
		connection = Mockito.mock(Connection.class);
		statement = Mockito.mock(Statement.class);
		resultSet = Mockito.mock(ResultSet.class);
		Mockito.when(connection.createStatement()).thenReturn(statement);
		Mockito.when(statement.executeQuery(DbQueries.SELECT_ACCOUNT_TABLE)).thenReturn(resultSet);
		Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
		Mockito.when(resultSet.getString("accountno")).thenReturn("000011111111");
		Mockito.when(resultSet.getString("accounttype")).thenReturn("Recurring Deposit");
		Mockito.when(resultSet.getLong("balance")).thenReturn(1210101L);

	}

	@Test
	public void createTableTest() throws Exception {
		AccountDaoService accountDaoService = new AccountDaoService(connection);
		accountDaoService.createTable();
	}

	@Test
	public void insertTest() throws Exception {
		AccountDaoService accountDaoService = new AccountDaoService(connection);
		accountDaoService.insert(getAccount());
	}

	@Test
	public void getDataTest() throws Exception {
		AccountDaoService accountDaoService = new AccountDaoService(connection);
		List<Object> accountDataList = accountDaoService.getData();
		for (Object obj : accountDataList) {
			Account account = (Account) obj;
			System.out.println(account);
		}
	}

	private Account getAccount() {
		Account account = new Account("000011111111", "Recurring Deposit", 1210101L);
		return account;
	}

}
