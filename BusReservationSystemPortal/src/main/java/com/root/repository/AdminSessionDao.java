package com.root.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.root.models.AdminSession;


public interface AdminSessionDao extends JpaRepository<AdminSession, Integer> {

    public Optional<AdminSession> findByAdminId(Integer adminId);
	
	public Optional<AdminSession> findByUuid(String uuid);

	public void save(String uuid);
	
}
