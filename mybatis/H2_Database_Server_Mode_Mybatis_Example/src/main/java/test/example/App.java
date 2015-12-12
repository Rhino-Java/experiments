package test.example;

import test.example.db.DaoService;
import test.example.db.SqlFactory;

public class App {
	public static void main(String[] args) {
		SqlFactory.createSqlSessionFactory();
		System.out.println("Create Table Operation -");
		DaoService.createTable();
		System.out.println("Insert Operation -");
		DaoService.insertData();
		System.out.println("Select Operation -");
		DaoService.getData();
		System.out.println("Delete Operation -");
		DaoService.deleteEmployees();
		System.out.println("Select Operation -");
		DaoService.getData();
		System.out.println("Insert Operation -");
		DaoService.insertData();
		System.out.println("Select Operation -");
		DaoService.getData();
		System.out.println("Update Operation -");
		DaoService.updateEmployees();
		System.out.println("Select Operation -");
		DaoService.getData();

	}
}
