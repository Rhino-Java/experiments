package test.example.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import test.example.dao.DaoService;
import test.example.db.DbQueries;
import test.example.model.Customer;

public class CustomerDaoService implements DaoService {

	private Connection connection;

	public CustomerDaoService(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void createTable() throws Exception {

		Statement stmt = connection.createStatement();
		stmt.execute(DbQueries.CREATE_CUSTOMER_TABLE);
		stmt.close();

	}

	@Override
	public void insert(Object obj) throws Exception {
		Customer customer = (Customer) obj;

		String insertQuery = String.format(DbQueries.INSERT_CUSTOMER_TABLE, customer.getId(), customer.getName(),
				customer.getGender(), new Date(customer.getDateOfBirth().getTime()), customer.getOccupation(),
				customer.getCity(), customer.getMobileNo(), customer.getAddress());

		Statement stmt = connection.createStatement();

		stmt.execute(insertQuery);

		stmt.close();
	}

	@Override
	public List<Object> getData() throws Exception {

		Statement stmt = connection.createStatement();

		ResultSet resultSet = stmt.executeQuery(DbQueries.SELECT_CUSTOMER_TABLE);

		List<Object> customers = new ArrayList<>();

		while (resultSet.next()) {

			Customer customer = new Customer(resultSet.getString("id"), resultSet.getString("name"),
					resultSet.getString("gender"), new Date(resultSet.getDate("dateofbirth").getTime()),
					resultSet.getString("occupation"), resultSet.getString("city"), resultSet.getString("mobileNo"),
					resultSet.getString("address"));

			customers.add(customer);

		}

		stmt.close();

		return customers;

	}
}
