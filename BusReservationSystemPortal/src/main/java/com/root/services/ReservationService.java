package com.root.services;

import java.util.List;

import com.root.DTO.ReservationDTO;
import com.root.exceptions.BusException;
import com.root.exceptions.ReservationException;
import com.root.models.Reservation;

public interface ReservationService {
	
	public Reservation addReservation(ReservationDTO reservationDTO) throws ReservationException , BusException;
	
	public Reservation updateReservation(Reservation reservation) throws ReservationException;
	
	public Reservation deleteReservation(Integer reservationId) throws ReservationException;
	
	public Reservation viewReservation(Integer reservationId) throws ReservationException;
	
	public List<Reservation> viewAllReservation()throws ReservationException;
	
}
