package test.example.db.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface CustomEmployeeMapper {

	/*
	 * '#' is used in PreparedStatements for passing column values.
	 * PreparedStatement place holders are not intended for table names nor
	 * column names, they are only intended for actual column values.
	 * 
	 * So, for passing table name and column name to SQL query '$' is used.
	 */
	@Update({
			"create table ${tableName} (empid int primary key auto_increment, empname varchar(200), occupation varchar(100), gender varchar (6), department varchar(100), dateofbirth date)" })
	int createTable(@Param("tableName") String tableName);

}