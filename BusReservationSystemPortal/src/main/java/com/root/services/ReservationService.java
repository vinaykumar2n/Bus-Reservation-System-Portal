package com.root.services;

import java.util.List;

import com.root.DTO.ReservationDTO;
import com.root.exceptions.BusException;
import com.root.exceptions.ReservationException;
import com.root.exceptions.UserException;
import com.root.models.Reservation;

public interface ReservationService {
	
	public Reservation addReservation(ReservationDTO reservationDTO, String key) throws ReservationException , BusException,UserException ;
	
	public Reservation updateReservation(Reservation reservation) throws ReservationException;
	
	public Reservation deleteReservation(Integer reservationId) throws ReservationException, BusException;
	
	public Reservation viewReservation(Integer reservationId) throws ReservationException;
	
	public List<Reservation> viewAllReservation()throws ReservationException;
	
}
