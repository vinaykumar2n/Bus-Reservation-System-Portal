package com.root.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.DTO.ReservationDTO;
import com.root.exceptions.AdminException;
import com.root.exceptions.BusException;
import com.root.exceptions.ReservationException;
import com.root.exceptions.UserException;
import com.root.models.Reservation;
import com.root.services.ReservationService;

@RestController
public class ReservationController {
	
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/reservation/user")
	public ResponseEntity<Reservation> addReservation(@Valid @RequestBody ReservationDTO reservationDTO ,@RequestParam(required = false) String key) throws ReservationException, BusException, UserException{
		Reservation savedReservation =reservationService.addReservation(reservationDTO,key);
		return new ResponseEntity<Reservation>(savedReservation,HttpStatus.ACCEPTED);
		
	}
	
	
	@DeleteMapping("/reservation/user/{id}")
	public ResponseEntity<Reservation> deleteReservation(@PathVariable("id") Integer reservationId,@RequestParam(required = false) String key ) throws ReservationException, BusException, UserException{
		Reservation deletedReservation = reservationService.deleteReservation(reservationId,key);
		return new ResponseEntity<Reservation>(deletedReservation,HttpStatus.OK);
	}
	
	
	@GetMapping("/reservation/admin/{id}")
	public ResponseEntity<Reservation> viewReservation(@PathVariable("id") Integer reservationId,@RequestParam(required = false) String key) throws ReservationException, AdminException{
		Reservation foundReservation = reservationService.viewReservation(reservationId,key);
		return new ResponseEntity<Reservation>(foundReservation,HttpStatus.OK);
	}
	
	
	@GetMapping("/reservation/admin")
	public ResponseEntity<List<Reservation>> viewAllReservation(@RequestParam(required = false) String key) throws ReservationException{
		List<Reservation> reservationList = reservationService.viewAllReservation(key);
		return new ResponseEntity<List<Reservation>>(reservationList,HttpStatus.OK);
	}
	
	
	@GetMapping("/reservation/user")
	public ResponseEntity<List<Reservation>> viewReservationByUser(@RequestParam(required = false) String key) throws ReservationException, UserException{
		
		List<Reservation> reservationList = reservationService.viewReservationByUser(key);
		return new ResponseEntity<List<Reservation>>(reservationList,HttpStatus.OK);
	}
	
}
