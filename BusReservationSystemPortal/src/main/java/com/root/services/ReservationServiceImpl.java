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
		
		if(reservationDTO.getJourneyDate().isBefore(LocalDate.now())) throw new ReservationException("Please enter future date!");
		
		if(!bus.getBusJourneyDate().isEqual(reservationDTO.getJourneyDate())) throw new ReservationException("Bus is not available on "+reservationDTO.getJourneyDate());
		
		if(!reservationDTO.getSource().equalsIgnoreCase(bus.getRouteFrom()) || !reservationDTO.getDestination().equalsIgnoreCase(bus.getRouteTo()))
			throw new ReservationException("Bus is not available on route : "+ reservationDTO.getSource()+" - "+reservationDTO.getDestination());
		
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
		reservation.setJourneyDate(reservationDTO.getJourneyDate());
		
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
	public Reservation deleteReservation(Integer reservationId) throws ReservationException, BusException {
		
		Optional<Reservation> Opt = reservationDao.findById(reservationId);
		Reservation foundReservation = Opt.orElseThrow(()-> new ReservationException("No reservation found!"));
		Bus bus = foundReservation.getBus();
		
		if(foundReservation.getJourneyDate().isBefore(LocalDate.now())) throw new ReservationException("Cannot cancel! Journey completed.");
		
		bus.setAvailableSeats(bus.getAvailableSeats()+foundReservation.getNoOfSeatsBooked());
		Bus updatedBus =busService.updateBus(bus);
		
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
