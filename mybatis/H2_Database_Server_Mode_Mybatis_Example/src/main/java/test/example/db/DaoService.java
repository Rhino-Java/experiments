package test.example.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.h2.tools.DeleteDbFiles;

import test.example.db.dao.CustomEmployeeMapper;
import test.example.db.dao.EmployeeMapper;
import test.example.model.Employee;
import test.example.model.EmployeeExample;

public class DaoService {

	public static void createTable() {

		DeleteDbFiles.execute(DbConstants.DB_DIR, DbConstants.DB_NAME, true);
		SqlSession sqlSession = SqlFactory.getSqlSesssionFactory().openSession();
		CustomEmployeeMapper customEmployeeMapper = sqlSession.getMapper(CustomEmployeeMapper.class);

		customEmployeeMapper.createEmployeeTable();
		sqlSession.commit();
		sqlSession.close();
		System.out.println("Table with name Employee is created");

	}

	public static void insertData() {

		SqlSession sqlSession = SqlFactory.getSqlSesssionFactory().openSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

		for (Employee employee : DbConstants.employeeTableData) {
			employee.setEmpid(0);
			System.out.println("Inserting Employee in the database\n" + employee);
			employeeMapper.insert(employee);
		}
		sqlSession.commit();

		sqlSession.close();
	}

	public static void getData() {

		SqlSession sqlSession = SqlFactory.getSqlSesssionFactory().openSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		EmployeeExample employeeExample = new EmployeeExample();

		List<Employee> employees = employeeMapper.selectByExample(employeeExample);
		if (employees.isEmpty()) {
			System.out.println("No Employee data found in the database");
		} else {
			System.out.println("Employees read from the database -");
		}
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		sqlSession.close();
	}

	public static void deleteEmployees() {

		SqlSession sqlSession = SqlFactory.getSqlSesssionFactory().openSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		EmployeeExample employeeExample = new EmployeeExample();

		int deletedRows = employeeMapper.deleteByExample(employeeExample);
		System.out.println(deletedRows + " rows are deleted from the database");

		sqlSession.commit();
		sqlSession.close();

	}

	public static void updateEmployees() {
		SqlSession sqlSession = SqlFactory.getSqlSesssionFactory().openSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		EmployeeExample employeeExample = new EmployeeExample();

		Employee employee = new Employee();
		employee.setDepartment("Student");

		int updatedRows = employeeMapper.updateByExampleSelective(employee, employeeExample);

		System.out.println(updatedRows + " rows are updated from the database and their department is set to student");
		sqlSession.commit();
		sqlSession.close();

	}
}
