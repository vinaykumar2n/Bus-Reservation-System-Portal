package com.root.services;

import com.root.exceptions.UserException;
import com.root.models.User;

public interface UserService {

	
	public User createUser(User user)throws UserException;
	
	public User updateUser(User user,String key)throws UserException;

}
