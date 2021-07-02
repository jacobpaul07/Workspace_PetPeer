package com.casestudy.service;

import java.util.List;

import com.casestudy.model.Pet;
import com.casestudy.model.User;

public interface UserService {

	public abstract User saveUser(User user);

	public abstract User authenticateUser(String name, String password);
	
}
