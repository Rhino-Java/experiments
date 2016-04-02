package test.example.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import test.example.dao.DaoService;
import test.example.db.DbQueries;
import test.example.model.CustomerAccountMapping;

public class CustomerAccountMappingDaoService implements DaoService {

	private Connection connection;

	public CustomerAccountMappingDaoService(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void createTable() throws Exception {
		Statement stmt = connection.createStatement();
		stmt.execute(DbQueries.CREATE_CUSTOMER_ACCOUNT_MAPPING_TABLE);
		stmt.close();

	}

	@Override
	public void insert(Object obj) throws Exception {

		CustomerAccountMapping customerAccountMapping = (CustomerAccountMapping) obj;

		String insertQuery = String.format(DbQueries.INSERT_CUSTOMER_ACCOUNT_MAPPING_TABLE,
				customerAccountMapping.getCustomerId(), customerAccountMapping.getAccountNo());

		Statement stmt = connection.createStatement();

		stmt.execute(insertQuery);

		stmt.close();

	}

	@Override
	public List<Object> getData() throws Exception {

		Statement stmt = connection.createStatement();

		ResultSet resultSet = stmt.executeQuery(DbQueries.SELECT_CUSTOMER_ACCOUNT_MAPPING_TABLE);

		List<Object> customerAccountMappings = new ArrayList<>();

		while (resultSet.next()) {

			CustomerAccountMapping customerAccountMapping = new CustomerAccountMapping(resultSet.getInt("id"),
					resultSet.getString("customerid"), resultSet.getString("accountno"));

			customerAccountMappings.add(customerAccountMapping);

		}

		stmt.close();

		return customerAccountMappings;

	}

}
