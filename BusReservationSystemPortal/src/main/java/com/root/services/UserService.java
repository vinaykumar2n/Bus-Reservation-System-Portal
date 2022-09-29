package com.root.services;

import com.root.models.User;

public interface UserService {
	
	public User createUser(User user);

	public User updateUser(User user, String key);

}
