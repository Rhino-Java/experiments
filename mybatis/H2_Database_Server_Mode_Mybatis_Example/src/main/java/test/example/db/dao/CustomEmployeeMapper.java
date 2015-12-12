package test.example.db.dao;

import org.apache.ibatis.annotations.Update;

public interface CustomEmployeeMapper {

	@Update({
			"create table Employee (empid int primary key auto_increment, empname varchar(200), occupation varchar(100), gender varchar (6), department varchar(100), dateofbirth date)" })
	int createEmployeeTable();

}
