package test.example.db.util;

import java.sql.Connection;

import test.example.dao.DaoService;
import test.example.dao.impl.AccountDaoService;
import test.example.dao.impl.CustomerAccountMappingDaoService;
import test.example.dao.impl.CustomerDaoService;

public class ServiceFactory {
	
	public static DaoService getAccountDaoService(Connection connection) {
		return new AccountDaoService(connection);
	}

	public static DaoService getCustomerDaoService(Connection connection) {
		return new CustomerDaoService(connection);
	}

	public static DaoService getCustomerAccountMappingDaoService(Connection connection) {
		return new CustomerAccountMappingDaoService(connection);
	}

}
