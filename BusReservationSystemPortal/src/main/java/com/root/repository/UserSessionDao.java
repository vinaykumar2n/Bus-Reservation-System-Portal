package com.root.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.root.models.CurrentUserSession;


public interface UserSessionDao extends JpaRepository<CurrentUserSession, Integer> {
	
	
	public CurrentUserSession findByUuid(String uuid);
	
}
