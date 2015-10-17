package test.example.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import test.example.model.Employee;

@Service
public class EmployeeService {

	public Employee getEmployee(String name) {

		Employee emp = new Employee(121, name, "Engineer", "male", "Technical", new Date());

		return emp;
	}

	public Employee addEmployee(Employee emp) {
		emp.setEmpId(9999999);
		System.out.println("Employee Added\n" + emp);
		return emp;
	}

}
