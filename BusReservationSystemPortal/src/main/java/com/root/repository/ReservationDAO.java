package com.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.root.models.Reservation;

@Repository
public interface ReservationDAO extends JpaRepository<Reservation, Integer>{
	
	
}
