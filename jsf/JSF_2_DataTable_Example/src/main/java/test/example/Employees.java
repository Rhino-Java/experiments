package test.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Employees implements Serializable {

	private static final long serialVersionUID = -5426063159000425558L;

	private List<Employee> employeeList = new ArrayList<>();

	public Employees() {
		employeeList.add(new Employee("120", "Albert", "Engineer", 10000));
		employeeList.add(new Employee("121", "Bob", "Senior Engineer", 12000));
		employeeList.add(new Employee("122", "Alice", "Project Lead", 24000));
		employeeList.add(new Employee("123", "Tom", "Project Manager", 32000));
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

}
