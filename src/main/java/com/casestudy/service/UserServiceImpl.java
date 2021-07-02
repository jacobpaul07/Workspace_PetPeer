package com.casestudy.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casestudy.dao.UserDAO;
import com.casestudy.dao.UserDAOImpl;
import com.casestudy.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;

	/*
	 * User Registration : add the details and return the retrieved object
	 * 
	 * Rule: Do not modify methods name or signature
	 * 
	 * Name:Nivedha V V
	 * 
	 * Email:nivedha.vv@hcl.com
	 * 
	 */
	public User saveUser(User user) {
		// Instead of below dummy code block replace your solution
	
		userDao.saveUser(user);
		return user;
	}

	/*
	 * User Login: validate the user details and return the retrieved object/null
	 * 
	 * Rule: Do not modify methods name or signature
	 * 
	 * Name:Nivedha V V
	 * 
	 * Email:nivedha.vv@hcl.com
	 * 
	 */
	public User authenticateUser(String name, String password) {
		// Instead of below dummy code block replace your solution
	
		User user;
		user= userDao.authenticateUser(name, password);
		return user;
	}

	/*
	 * DO NOT ALTER/DELETE below method
	 */
	public void setUserDao(UserDAOImpl userDao) {
		this.userDao = userDao;
	}

	/*
	 * DO NOT ALTER/DELETE below method
	 */
	public UserServiceImpl(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}

}
