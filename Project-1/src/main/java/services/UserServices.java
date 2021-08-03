package services;

import models.User;
import dao.UserDao;

public class UserServices {
	UserDao uDao = new UserDao();
	public User login(String username, String password) {
		return uDao.getUser(username, password);
	}
	public User signUp(String firstName, String lastName, String password, String email, int userRole) {
		return uDao.createUser(new User(firstName, lastName, password, email, userRole));
		 
	}

}
