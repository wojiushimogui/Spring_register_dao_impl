package com.register.service.impl;


import com.register.dao.UserDao;
import com.register.dao.impl.UserDaoImpl;
import com.register.model.User;
import com.register.service.UserManager;

public class UserManagerImpl implements UserManager{
	
	private UserDao userDao=new UserDaoImpl();
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean exists(User user) {
		
		return userDao.exists(user);
	}
	
	public void save(User user) {
		
		 userDao.save(user);
	}
}
