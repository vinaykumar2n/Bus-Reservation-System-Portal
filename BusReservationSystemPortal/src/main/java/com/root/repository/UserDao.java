package com.root.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.root.models.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public Optional<User> findByUserName(String userName);
	
}
