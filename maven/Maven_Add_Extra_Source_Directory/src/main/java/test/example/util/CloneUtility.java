package test.example.util;

import test.example.model.Employee;

public class CloneUtility {

	public static Employee cloneEmployee(Employee emp) {
		Employee clonedEmployee = new Employee();
		clonedEmployee.setDateofbirth(emp.getDateofbirth());
		clonedEmployee.setDepartment(emp.getDepartment());
		clonedEmployee.setEmpid(emp.getEmpid());
		clonedEmployee.setEmpname(emp.getEmpname());
		clonedEmployee.setGender(emp.getGender());
		clonedEmployee.setOccupation(emp.getOccupation());

		return clonedEmployee;
	}
}
