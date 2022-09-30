package com.root.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.DTO.ReservationDTO;
import com.root.exceptions.BusException;
import com.root.exceptions.ReservationException;
import com.root.exceptions.UserException;
import com.root.models.Reservation;
import com.root.services.ReservationService;

@RestController
public class ReservationController {
	
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/reservation")
	public ResponseEntity<Reservation> addReservation(@RequestBody ReservationDTO reservationDTO ,@RequestParam(required = false) String key) throws ReservationException, BusException, UserException{
		Reservation savedReservation =reservationService.addReservation(reservationDTO,key);
		return new ResponseEntity<Reservation>(savedReservation,HttpStatus.ACCEPTED);
		
	}
	
//	@PutMapping("/reservation")
//	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) throws ReservationException{
//		Reservation updatedReservation = reservationService.updateReservation(reservation);
//		return new ResponseEntity<Reservation>(updatedReservation,HttpStatus.OK);
//		
//	}
	
	@DeleteMapping("/reservation/{id}")
	public ResponseEntity<Reservation> deleteReservation(@PathVariable("id") Integer reservationId) throws ReservationException, BusException{
		Reservation deletedReservation = reservationService.deleteReservation(reservationId);
		return new ResponseEntity<Reservation>(deletedReservation,HttpStatus.OK);
	}
	
	@GetMapping("/reservation/{id}")
	public ResponseEntity<Reservation> viewReservation(@PathVariable("id") Integer reservationId) throws ReservationException{
		Reservation foundReservation = reservationService.viewReservation(reservationId);
		return new ResponseEntity<Reservation>(foundReservation,HttpStatus.OK);
	}
	
	@GetMapping("/reservation")
	public ResponseEntity<List<Reservation>> viewAllReservation() throws ReservationException{
		List<Reservation> reservationList = reservationService.viewAllReservation();
		return new ResponseEntity<List<Reservation>>(reservationList,HttpStatus.OK);
	}
}
