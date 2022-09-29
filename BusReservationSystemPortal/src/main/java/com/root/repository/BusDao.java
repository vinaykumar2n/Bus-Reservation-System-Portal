package com.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.root.models.Bus;

@Repository
public interface BusDao extends JpaRepository<Bus, Integer>{

	
}
