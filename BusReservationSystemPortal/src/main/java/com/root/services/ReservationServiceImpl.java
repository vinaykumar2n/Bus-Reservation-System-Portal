package com.root.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.DTO.ReservationDTO;
import com.root.exceptions.BusException;
import com.root.exceptions.ReservationException;
import com.root.exceptions.RouteException;
import com.root.models.Bus;
import com.root.models.Reservation;
import com.root.repository.BusDao;
import com.root.repository.ReservationDAO;


@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDAO reservationDao;
	
	@Autowired
	private BusDao busDao;
	
	@Autowired
	private BusService busService;
	
	@Override
	public Reservation addReservation(ReservationDTO reservationDTO) throws ReservationException, BusException {
		
		Optional<Bus> opt = busDao.findById(reservationDTO.getBusDTO().getBusId());
		
		Bus bus = opt.orElseThrow(()-> new ReservationException("Invalid bus details!"));
		
		int seatsAvailable = bus.getAvailableSeats();
		if(seatsAvailable < reservationDTO.getNoOfSeatsToBook()) throw new ReservationException("Reservation Failed! Available seats: "+seatsAvailable);
		
		Reservation reservation = new Reservation();
		
		bus.setAvailableSeats(seatsAvailable - reservationDTO.getNoOfSeatsToBook());
		
		Bus updatedBus =busService.updateBus(bus);
		
		reservation.setBus(updatedBus);
		
		reservation.setReservationStatus("Successfull");
		reservation.setReservationDate(LocalDate.now());
		reservation.setReservationTime(LocalTime.now());
		reservation.setSource(bus.getRouteFrom());
		reservation.setDestination(bus.getRouteTo());
		reservation.setNoOfSeatsBooked(reservationDTO.getNoOfSeatsToBook());
		reservation.setFare(bus.getFarePerSeat()*(reservationDTO.getNoOfSeatsToBook()));
		
		Reservation savedReservation = reservationDao.save(reservation);
		if(savedReservation == null) throw new ReservationException("Could not reserve the seats");
		return savedReservation;
	}

	@Override
	public Reservation updateReservation(Reservation reservation) throws ReservationException {
		
		Optional<Reservation> opt = reservationDao.findById(reservation.getReservationId());
		Reservation foundReservation = opt.orElseThrow(()-> new ReservationException("No reservation found!"));
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
	public List<Reservation> viewAllReservation() throws ReservationException {
		List<Reservation> reservationList = reservationDao.findAll();
		if(reservationList.isEmpty()) throw new ReservationException("No reservation found!");
		return reservationList;
	}

	
	
	
}
