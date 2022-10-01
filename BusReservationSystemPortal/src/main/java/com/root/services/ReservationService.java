package com.root.services;

import java.util.List;

import com.root.DTO.ReservationDTO;
import com.root.exceptions.AdminException;
import com.root.exceptions.BusException;
import com.root.exceptions.ReservationException;
import com.root.exceptions.UserException;
import com.root.models.Reservation;

public interface ReservationService {
	
	public Reservation addReservation(ReservationDTO reservationDTO, String key) throws ReservationException , BusException,UserException ;
		
	public Reservation deleteReservation(Integer reservationId, String key) throws ReservationException, BusException, UserException;
	
	public Reservation viewReservation(Integer reservationId,String key) throws ReservationException, AdminException;
	
	public List<Reservation> viewAllReservation(String key)throws ReservationException;
	
	public List<Reservation> viewReservationByUser(String key) throws ReservationException, UserException;
	
}
