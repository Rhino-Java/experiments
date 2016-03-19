package test.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import test.example.dao.UserDao;

@Service
public class UserDaoImpl implements UserDao {

	@Override
	public List<String> getUserDetails() {
		List<String> details = new ArrayList<>();
		details.add("Robert");
		details.add("John");
		details.add("Albert");
		details.add("Caesar");
		return details;
	}

}
