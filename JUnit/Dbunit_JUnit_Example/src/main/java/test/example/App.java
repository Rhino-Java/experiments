package test.example;

import java.util.Calendar;

import test.example.db.DbUtil;
import test.example.model.Account;
import test.example.model.Customer;

public class App {
	public static void main(String[] args) throws Exception {
		DbUtil.createTables();

		insertData();

		DbUtil.printTablesData();
	}

	private static void insertData() throws Exception {
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(1882, 11, 2);
		Customer customer = new Customer("23FEFE829MF", "Bob", "Male", dateOfBirth.getTime(), "Teacher", "New York",
				"9174944476", "445 Fifth Avenue, Suite 32D, New York, N.Y. 10016");
		Account account = new Account("000011111111", "Saving", 1210101L);
		DbUtil.InsertTablesData(customer, account);
	}
}
