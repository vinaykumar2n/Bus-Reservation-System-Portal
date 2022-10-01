package com.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.root.models.CurrentAdminSession;


public interface AdminSessionDao extends JpaRepository<CurrentAdminSession, Integer> {

	public  CurrentAdminSession findByUuid(String uuid);

}
