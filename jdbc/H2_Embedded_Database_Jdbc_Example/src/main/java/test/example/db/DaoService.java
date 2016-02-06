package test.example.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.DeleteDbFiles;

import test.example.model.Employee;

public class DaoService {

	public static void createTable() throws ClassNotFoundException, SQLException {
		// Delete database file, if already exist
		DeleteDbFiles.execute(DbConstants.DB_DIR, DbConstants.DATABASE_NAME, true);
		Connection connection = ConnectionFactory.getConnection();

		connection.setAutoCommit(false);

		Statement stmt = connection.createStatement();
		stmt.execute(DbQueries.CREATE_EMP_TABLE);
		stmt.close();
		connection.commit();

		connection.close();

		System.out.println("Table with name Employee is created");

	}

	public static void insertDataUsingStatement() throws SQLException, ClassNotFoundException {

		Connection connection = ConnectionFactory.getConnection();

		connection.setAutoCommit(false);
		Statement stmt = connection.createStatement();

		for (Employee emp : DbConstants.employeeTableData) {

			System.out.println("Inserting Employee in the database\n" + emp);

			String insertQuery = String.format(DbQueries.INSERT_EMP_TABLE, emp.getEmpName(), emp.getOccupation(),
					emp.getGender(), emp.getDepartment(), new Date(emp.getDateOfBirth().getTime()));
			stmt.execute(insertQuery);

		}

		stmt.close();
		connection.commit();

		connection.close();

	}

	public static void getData() throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionFactory.getConnection();
		Statement stmt = connection.createStatement();
		connection.setAutoCommit(false);
		ResultSet resultSet = stmt.executeQuery(DbQueries.SELECT_EMP_TABLE);

		int count = 0;
		while (resultSet.next()) {

			Employee emp = new Employee(resultSet.getInt("empid"), resultSet.getString("empname"),
					resultSet.getString("occupation"), resultSet.getString("gender"), resultSet.getString("department"),
					new Date(resultSet.getDate("dateofbirth").getTime()));
			if (count == 0) {
				System.out.println("Employees read from the database-");
			}
			count++;
			System.out.println(emp);
		}
		if (count == 0) {
			System.out.println("No Employee data found in the database");
		}
		stmt.close();
		connection.commit();

		connection.close();

	}

	public static void insertUsingPreparedStatement() throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement insertPreparedStatement = null;
		connection.setAutoCommit(false);

		insertPreparedStatement = connection.prepareStatement(DbQueries.PREPARED_INSERT_EMP_TABLE);

		for (Employee emp : DbConstants.employeeTableData) {
			System.out.println("Inserting Employee in the database\n" + emp);
			insertPreparedStatement.setString(1, emp.getEmpName());
			insertPreparedStatement.setString(2, emp.getOccupation());
			insertPreparedStatement.setString(3, emp.getGender());
			insertPreparedStatement.setString(4, emp.getDepartment());
			insertPreparedStatement.setDate(5, new Date(emp.getDateOfBirth().getTime()));
			insertPreparedStatement.executeUpdate();
		}

		insertPreparedStatement.close();

		connection.commit();

		connection.close();
	}

	public static void deleteEmployees() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		connection.setAutoCommit(false);
		Statement stmt = connection.createStatement();

		int deletedRows = stmt.executeUpdate(DbQueries.DELETE_EMP_TABLE);

		System.out.println(deletedRows + " rows are deleted from the database");

		stmt.close();
		connection.commit();
		connection.close();

	}

	public static void updateEmployees() throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionFactory.getConnection();
		connection.setAutoCommit(false);
		Statement stmt = connection.createStatement();

		String updateQuery = String.format(DbQueries.UPDATE_EMP_TABLE, "student");

		int updatedRows = stmt.executeUpdate(updateQuery);

		System.out.println(updatedRows + " rows are updated from the database and their department is set to student");

		stmt.close();
		connection.commit();
		connection.close();
	}
}