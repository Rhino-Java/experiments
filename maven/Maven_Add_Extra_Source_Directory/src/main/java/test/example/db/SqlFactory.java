package test.example.db;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class SqlFactory {

	private static SqlSessionFactory sqlSesssionFactory;

	public static void createSqlSessionFactory() {
		DataSource dataSource = getDataSource();

		TransactionFactory transactionFactory = new JdbcTransactionFactory();

		Environment environment = new Environment("production", transactionFactory, dataSource);

		Configuration configuration = new Configuration(environment);

		// Package mappers registration
		configuration.addMappers(DbConstants.DB_MAPPER_PACKAGE);

		sqlSesssionFactory = new SqlSessionFactoryBuilder().build(configuration);
	}

	private static DataSource getDataSource() {

		PooledDataSource pooledDataSource = new PooledDataSource(DbConstants.DB_DRIVER, DbConstants.DB_CONNECTION_URL,
				DbConstants.DB_USER, DbConstants.DB_PASSWORD);

		// Maximum Active Pool Connections
		pooledDataSource.setPoolMaximumActiveConnections(1);

		return pooledDataSource;
	}

	public static SqlSessionFactory getSqlSesssionFactory() {
		return sqlSesssionFactory;
	}

}
