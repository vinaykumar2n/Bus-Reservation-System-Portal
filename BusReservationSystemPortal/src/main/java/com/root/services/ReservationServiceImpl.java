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
import com.root.exceptions.UserException;
import com.root.models.Bus;
import com.root.models.CurrentAdminSession;
import com.root.models.CurrentUserSession;
import com.root.models.Reservation;
import com.root.models.User;
import com.root.repository.AdminSessionDao;
import com.root.repository.BusDao;
import com.root.repository.ReservationDAO;
import com.root.repository.UserDao;
import com.root.repository.UserSessionDao;


@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDAO reservationDao;
	
	@Autowired
	private BusDao busDao;
	
	@Autowired
	private UserSessionDao userSessionDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;
	
	@Override
	public Reservation addReservation(ReservationDTO reservationDTO, String key) throws ReservationException, BusException,UserException {
		
		CurrentUserSession loggedInUser= userSessionDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please provide a valid key to reserve seats!");
		}
		
		User user = userDao.findById(loggedInUser.getUserId()).orElseThrow(()-> new UserException("User not found!"));
		
		
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
		
		Bus updatedBus =busDao.save(bus);
		
		reservation.setBus(updatedBus);
		
		reservation.setReservationStatus("Successfull");
		reservation.setReservationDate(LocalDate.now());
		reservation.setReservationTime(LocalTime.now());
		reservation.setSource(bus.getRouteFrom());
		reservation.setDestination(bus.getRouteTo());
		reservation.setNoOfSeatsBooked(reservationDTO.getNoOfSeatsToBook());
		reservation.setFare(bus.getFarePerSeat()*(reservationDTO.getNoOfSeatsToBook()));
		reservation.setJourneyDate(reservationDTO.getJourneyDate());
		
		List<Reservation> userReservations =user.getReservations();
		userReservations.add(reservation);
		
		user.setReservations(userReservations);
		
		reservation.setUser(user);
		
		Reservation savedReservation = reservationDao.save(reservation);
		
		if(savedReservation == null) throw new ReservationException("Could not reserve the seats");
		return savedReservation;
	}



	@Override
	public Reservation deleteReservation(Integer reservationId,String key) throws ReservationException, BusException, UserException {
		
		CurrentUserSession loggedInUser= userSessionDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please provide a valid key to reserve seats!");
		}
		
		User user = userDao.findById(loggedInUser.getUserId()).orElseThrow(()-> new UserException("User not found!"));
		
		List<Reservation> reservationList = user.getReservations();
		
		boolean validReservationId= false;
		
		for(int i=0;i<reservationList.size();i++) {
			
			if(reservationList.get(i).getReservationId() == reservationId)
			{
				validReservationId = true;
				
				Optional<Reservation> Opt = reservationDao.findById(reservationId);
				Reservation foundReservation = Opt.orElseThrow(()-> new ReservationException("No reservation found!"));
				Bus bus = foundReservation.getBus();
				
				if(foundReservation.getJourneyDate().isBefore(LocalDate.now())) throw new ReservationException("Cannot cancel! Journey completed.");
				
				bus.setAvailableSeats(bus.getAvailableSeats()+foundReservation.getNoOfSeatsBooked());
				Bus updatedBus =busDao.save(bus);
				
				reservationList.remove(i);
				reservationDao.delete(foundReservation);
				return foundReservation;
			}
		}
		
		if(!validReservationId) throw new UserException("Reservation Id:"+reservationId+" do not belong to the current user!");
		return null;
	}

	@Override
	public Reservation viewReservation(Integer reservationId,String key) throws ReservationException {
		
		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new ReservationException("Please provide a valid key to view reservation!");
		}
		
		Optional<Reservation> Opt = reservationDao.findById(reservationId);
		Reservation foundReservation = Opt.orElseThrow(()-> new ReservationException("No reservation found!"));
		return foundReservation;
	}

	@Override
	public List<Reservation> viewAllReservation(String key) throws ReservationException {
		
		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new ReservationException("Please provide a valid key to view all reservations!");
		}
		
		List<Reservation> reservationList = reservationDao.findAll();
		if(reservationList.isEmpty()) throw new ReservationException("No reservations found!");
		return reservationList;
	}



	@Override
	public List<Reservation> viewReservationByUser(String key) throws ReservationException, UserException {
		
		CurrentUserSession loggedInUser= userSessionDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please provide a valid key to view reservation!");
		}
		
		User user = userDao.findById(loggedInUser.getUserId()).orElseThrow(()-> new UserException("User not found!"));
		
		return user.getReservations();
	}

	
	
}
