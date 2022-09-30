package com.root.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.root.models.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public User findByMobileNumber(String mobileNumber);
	
}
