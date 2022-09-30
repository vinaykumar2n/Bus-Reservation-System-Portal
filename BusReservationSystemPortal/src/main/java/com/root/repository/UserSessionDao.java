package com.root.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.root.models.UserSession;


public interface UserSessionDao extends JpaRepository<UserSession, Integer> {

    public Optional<UserSession> findByUserLoginId(Integer userLoginId);
	
	public Optional<UserSession> findByUuid(String uuid);

	public void save(String uuid);
	
}
