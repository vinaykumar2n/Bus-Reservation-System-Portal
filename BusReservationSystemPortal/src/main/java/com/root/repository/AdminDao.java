package com.root.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.root.models.Admin;


public interface AdminDao extends JpaRepository<Admin, Integer> {

	
	public Admin findByMobileNumber(String mobileNumber);
	
}
