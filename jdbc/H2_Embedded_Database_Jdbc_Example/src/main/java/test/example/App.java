package test.example;

import java.sql.SQLException;

import test.example.db.DaoService;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		System.out.println("Create Table Operation -");
		DaoService.createTable();
		System.out.println("Insert Using Statement Operation -");
		DaoService.insertDataUsingStatement();
		System.out.println("Select Operation -");
		DaoService.getData();
		System.out.println("Delete Operation -");
		DaoService.deleteEmployees();
		System.out.println("Select Operation -");
		DaoService.getData();
		System.out.println("Insert Using Prepared Operation -");
		DaoService.insertUsingPreparedStatement();
		System.out.println("Select Operation -");
		DaoService.getData();
		System.out.println("Update Operation -");
		DaoService.updateEmployees();
		System.out.println("Select Operation -");
		DaoService.getData();

	}
}
