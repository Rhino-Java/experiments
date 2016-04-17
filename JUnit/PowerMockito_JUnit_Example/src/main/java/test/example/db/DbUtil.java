package test.example.db;

import java.sql.Connection;
import java.util.List;

import org.h2.tools.DeleteDbFiles;

import test.example.db.util.ConnectionFactory;
import test.example.db.util.ServiceFactory;
import test.example.model.Account;
import test.example.model.Customer;
import test.example.model.CustomerAccountMapping;

public class DbUtil {

	public static void createTables() throws Exception {
		DeleteDbFiles.execute(DbConstants.DB_DIR, DbConstants.DATABASE_NAME, true);
		Connection connection = ConnectionFactory.getConnection();
		ServiceFactory.getAccountDaoService(connection).createTable();
		ServiceFactory.getCustomerDaoService(connection).createTable();
		ServiceFactory.getCustomerAccountMappingDaoService(connection).createTable();
		connection.commit();
		connection.close();
		System.out.println("Customer, Account and CustomerAccountMapping tables are created");
	}

	public static void printTablesData() throws Exception {
		Connection connection = ConnectionFactory.getConnection();
		List<Object> customers = ServiceFactory.getCustomerDaoService(connection).getData();
		List<Object> accounts = ServiceFactory.getAccountDaoService(connection).getData();
		List<Object> customerAccountMappings = ServiceFactory.getCustomerAccountMappingDaoService(connection).getData();
		connection.commit();
		connection.close();
		System.out.println("Printing tables data -");
		if (customers.isEmpty()) {
			System.out.println("\nNo Data found in Customer Table");
		} else {
			System.out.println("\nCustomer Table Data -");
			for (Object obj : customers) {
				System.out.println((Customer) obj);
			}
		}
		if (accounts.isEmpty()) {
			System.out.println("\nNo Data found in Account Table");
		} else {
			System.out.println("\nAccount Table Data -");
			for (Object obj : accounts) {
				System.out.println((Account) obj);
			}
		}
		if (customerAccountMappings.isEmpty()) {
			System.out.println("\nNo Data found in CustomerAccountMapping Table");
		} else {
			System.out.println("\nCustomerAccountMapping Table Data -");
			for (Object obj : customerAccountMappings) {
				System.out.println((CustomerAccountMapping) obj);
			}
		}
	}

	public static void InsertTablesData(Customer customer, Account account) throws Exception {
		System.out.println("Inserting data in tables \n" + customer + "\n" + account);
		Connection connection = ConnectionFactory.getConnection();
		ServiceFactory.getCustomerDaoService(connection).insert(customer);
		ServiceFactory.getAccountDaoService(connection).insert(account);
		CustomerAccountMapping customerAccountMapping = new CustomerAccountMapping(customer.getId(),
				account.getAccountNo());
		ServiceFactory.getCustomerAccountMappingDaoService(connection).insert(customerAccountMapping);
		connection.commit();
		connection.close();
		System.out.println("Data insertion is completed");
	}

}
