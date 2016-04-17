package test.example.db;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.h2.tools.DeleteDbFiles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import test.example.dao.impl.AccountDaoService;
import test.example.dao.impl.CustomerAccountMappingDaoService;
import test.example.dao.impl.CustomerDaoService;
import test.example.db.util.ConnectionFactory;
import test.example.db.util.ServiceFactory;
import test.example.model.Account;
import test.example.model.Customer;
import test.example.model.CustomerAccountMapping;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ServiceFactory.class, ConnectionFactory.class })
public class DbUtilTest {

	private CustomerDaoService customerDaoService;

	private AccountDaoService accountDaoService;

	private CustomerAccountMappingDaoService customerAccountMappingDaoService;

	@Before
	public void setUp() throws Exception {
		PowerMockito.mockStatic(ConnectionFactory.class);

		Connection connection = Mockito.mock(Connection.class);

		PowerMockito.when(ConnectionFactory.getConnection()).thenReturn(connection);

		customerDaoService = Mockito.mock(CustomerDaoService.class);
		Mockito.when(customerDaoService.getData()).thenReturn(getCustomerTableTestData());

		accountDaoService = Mockito.mock(AccountDaoService.class);
		Mockito.when(accountDaoService.getData()).thenReturn(getAccountTableTestData());

		customerAccountMappingDaoService = Mockito.mock(CustomerAccountMappingDaoService.class);
		Mockito.when(customerAccountMappingDaoService.getData()).thenReturn(getCustomerAccountMappingTableTestData());

		PowerMockito.mockStatic(ServiceFactory.class);

		PowerMockito.when(ServiceFactory.getCustomerDaoService(connection)).thenReturn(customerDaoService);
		PowerMockito.when(ServiceFactory.getAccountDaoService(connection)).thenReturn(accountDaoService);
		PowerMockito.when(ServiceFactory.getCustomerAccountMappingDaoService(connection))
				.thenReturn(customerAccountMappingDaoService);

		PowerMockito.mockStatic(DeleteDbFiles.class);

	}

	@Test
	public void printTablesDataTest1() throws Exception {
		DbUtil.printTablesData();
	}

	@Test
	public void printTablesDataTest2() throws Exception {
		Mockito.when(customerDaoService.getData()).thenReturn(new ArrayList<Object>());
		Mockito.when(accountDaoService.getData()).thenReturn(new ArrayList<Object>());
		Mockito.when(customerAccountMappingDaoService.getData()).thenReturn(new ArrayList<Object>());
		DbUtil.printTablesData();
	}

	@Test
	public void InsertTablesDataTest() throws Exception {
		DbUtil.InsertTablesData(getCustomer(), getAccount());
	}

	@Test
	public void createTablesTest() throws Exception {
		DbUtil.createTables();
	}

	private List<Object> getCustomerTableTestData() {
		List<Object> customerList = new ArrayList<>();
		customerList.add(getCustomer());
		return customerList;
	}

	private List<Object> getAccountTableTestData() {
		List<Object> accountList = new ArrayList<>();
		accountList.add(getAccount());
		return accountList;
	}

	private List<Object> getCustomerAccountMappingTableTestData() {
		List<Object> customerAccountMappingList = new ArrayList<>();
		customerAccountMappingList.add(getCustomerAccountMapping());
		return customerAccountMappingList;
	}

	private Customer getCustomer() {
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(1882, 11, 2);
		Customer customer = new Customer("23FEFE829MF", "Bob", "Male", dateOfBirth.getTime(), "Student", "New York",
				"9174944476", "445 Fifth Avenue, Suite 32D, New York, N.Y. 10016");
		return customer;
	}

	private Account getAccount() {
		Account account = new Account("000011111111", "Recurring Deposit", 1210101L);
		return account;
	}

	private CustomerAccountMapping getCustomerAccountMapping() {
		CustomerAccountMapping customerAccountMapping = new CustomerAccountMapping(101, "23FEFE829MF", "000011111111");
		return customerAccountMapping;
	}

}
