package com.root.services;

import java.time.LocalDate;
import java.util.List;

import com.root.exceptions.ReservationException;
import com.root.models.Reservation;

public interface ReservationService {
	
	public Reservation addReservation(Reservation reservation) throws ReservationException;
	
	public Reservation updateReservation(Reservation reservation) throws ReservationException;
	
	public Reservation deleteReservation(Integer reservationId) throws ReservationException;
	
	public Reservation viewReservation(Integer reservationId) throws ReservationException;
	
	public List<Reservation> viewAllReservation()throws ReservationException;
	
}
