package test.example.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import test.example.dao.UserDao;

@Component
@ManagedBean
@SessionScoped
public class UserBean {

	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<String> getUserDetails() {
		return userDao.getUserDetails();
	}

}
