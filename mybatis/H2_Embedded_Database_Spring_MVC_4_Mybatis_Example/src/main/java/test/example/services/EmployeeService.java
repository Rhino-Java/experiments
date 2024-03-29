package test.example.services;

import java.util.Arrays;
import java.util.List;

import org.h2.tools.DeleteDbFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.example.db.DbConstants;
import test.example.db.dao.CustomEmployeeMapper;
import test.example.db.dao.EmployeeMapper;
import test.example.model.Employee;
import test.example.model.EmployeeExample;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private CustomEmployeeMapper customEmployeeMapper;

	/*
	 * Deleting database file is not a transaction. That is why, @Transactional
	 * annotation is not used in this method.
	 */
	public void deleteOldTable() {
		DeleteDbFiles.execute(DbConstants.DB_DIR, DbConstants.DATABASE_NAME, true);
	}

	@Transactional
	public void createTable() {

		customEmployeeMapper.createTable("Employee");
	}

	@Transactional
	public List<Employee> getEmployees() {
		EmployeeExample employeeExample = new EmployeeExample();
		return employeeMapper.selectByExample(employeeExample);
	}

	@Transactional
	public List<Employee> insertData() {
		for (Employee employee : DbConstants.employeeTableData) {
			employeeMapper.insert(employee);
		}
		return Arrays.asList(DbConstants.employeeTableData);
	}

	@Transactional
	public int deteteEmployees() {
		EmployeeExample employeeExample = new EmployeeExample();
		int deletedRows = employeeMapper.deleteByExample(employeeExample);
		return deletedRows;
	}

	@Transactional
	public int updateEmployees() {
		EmployeeExample employeeExample = new EmployeeExample();
		Employee employee = new Employee();
		employee.setDepartment("Student");
		int updatedRows = employeeMapper.updateByExampleSelective(employee, employeeExample);
		return updatedRows;
	}
}