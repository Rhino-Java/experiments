package test.example.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import test.example.dao.DaoService;
import test.example.db.DbQueries;
import test.example.model.Account;

public class AccountDaoService implements DaoService {

	private Connection connection;

	public AccountDaoService(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void createTable() throws Exception {

		Statement stmt = connection.createStatement();
		stmt.execute(DbQueries.CREATE_ACCOUNT_TABLE);
		stmt.close();

	}

	@Override
	public void insert(Object obj) throws Exception {

		Account account = (Account) obj;

		String insertQuery = String.format(DbQueries.INSERT_ACCOUNT_TABLE, account.getAccountNo(),
				account.getAccountType(), account.getBalance());

		Statement stmt = connection.createStatement();

		stmt.execute(insertQuery);

		stmt.close();

	}

	@Override
	public List<Object> getData() throws Exception {

		Statement stmt = connection.createStatement();

		ResultSet resultSet = stmt.executeQuery(DbQueries.SELECT_ACCOUNT_TABLE);

		List<Object> accounts = new ArrayList<>();

		while (resultSet.next()) {

			Account accont = new Account(resultSet.getString("accountno"), resultSet.getString("accounttype"),
					resultSet.getLong("balance"));

			accounts.add(accont);

		}

		stmt.close();

		return accounts;

	}
}