package test.example.model;

import java.util.Date;

public class Employee {

	private int empId;

	private String empName;

	private String occupation;

	private String gender;

	private String department;

	private Date dateOfBirth;

	public Employee() {

	}

	public Employee(int empId, String empName, String occupation, String gender, String department, Date dateOfBirth) {
		this.empId = empId;
		this.empName = empName;
		this.occupation = occupation;
		this.gender = gender;
		this.department = department;
		this.dateOfBirth = dateOfBirth;
	}

	public Employee(String empName, String occupation, String gender, String department, Date dateOfBirth) {

		this.empName = empName;
		this.occupation = occupation;
		this.gender = gender;
		this.department = department;
		this.dateOfBirth = dateOfBirth;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", occupation=" + occupation + ", gender=" + gender
				+ ", department=" + department + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
