package com.casestudy.dao;




import com.casestudy.model.User;

public interface UserDAO {

	public abstract User saveUser(User user);

	public abstract User authenticateUser(String name, String password);
	
	

}
