package test.example.dao;

import java.util.List;

public interface DaoService {

	public void createTable() throws Exception;

	public void insert(Object obj) throws Exception;

	public List<Object> getData() throws Exception;

}
