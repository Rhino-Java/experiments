package test.example.db.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;


public class ConnectionFactoryTest {

	@Test
	public void testGetConnection1() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		Assert.assertNotNull(connection);
	}

	@Test
	public void testGetConnection2() throws ClassNotFoundException, SQLException {
		Connection connection1 = ConnectionFactory.getConnection();
		Assert.assertNotNull(connection1);
		Connection connection2 = ConnectionFactory.getConnection();
		Assert.assertNotNull(connection2);
		Assert.assertNotEquals(connection1, connection2);
	}
}
