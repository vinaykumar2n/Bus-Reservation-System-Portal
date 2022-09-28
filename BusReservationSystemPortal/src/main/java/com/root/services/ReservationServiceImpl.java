package com.root.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.exceptions.ReservationException;
import com.root.models.Reservation;
import com.root.repository.ReservationDAO;


@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDAO reservationDao;
	
	@Override
	public Reservation addReservation(Reservation reservation) throws ReservationException {
		
		Reservation savedReservation = reservationDao.save(reservation);
		if(savedReservation == null) throw new ReservationException("Could not reserve the seats");
		return savedReservation;
	}

	@Override
	public Reservation updateReservation(Reservation reservation) throws ReservationException {
		
		Optional<Reservation> Opt = reservationDao.findById(reservation.getReservationId());
		Reservation foundReservation = Opt.orElseThrow(()-> new ReservationException("No reservation found!"));
		Reservation updatedReservation =reservationDao.save(reservation);
		return updatedReservation;
	}

	@Override
	public Reservation deleteReservation(Integer reservationId) throws ReservationException {
		
		Optional<Reservation> Opt = reservationDao.findById(reservationId);
		Reservation foundReservation = Opt.orElseThrow(()-> new ReservationException("No reservation found!"));
		reservationDao.delete(foundReservation);
		return foundReservation;
	}

	@Override
	public Reservation viewReservation(Integer reservationId) throws ReservationException {
		Optional<Reservation> Opt = reservationDao.findById(reservationId);
		Reservation foundReservation = Opt.orElseThrow(()-> new ReservationException("No reservation found!"));
		return foundReservation;
	}

	@Override
	public List<Reservation> viewAllReservation() {
		List<Reservation> reservationList = reservationDao.findAll();
		if(reservationList.isEmpty()) new ReservationException("No reservation found!");
		return reservationList;
	}

	
	
	
}
