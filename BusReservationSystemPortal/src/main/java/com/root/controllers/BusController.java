package com.root.controllers;

import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.root.exceptions.BusException;
import com.root.models.Bus;
import com.root.services.BusService;

@RestController
public class BusController {

	@Autowired
	private BusService busService;
	
	@PostMapping("/bus")
	public ResponseEntity<Bus> addBus( @RequestBody Bus bus) throws BusException{
		
		Bus newBus=busService.addBus(bus);
		
		return new ResponseEntity<Bus>(newBus,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateBus")
	public ResponseEntity<Bus> updateBus(@Valid @RequestBody Bus bus) throws BusException{
		
		Bus newBus=busService.updateBus(bus);
		
		return new ResponseEntity<Bus>(newBus,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/bus/{busId}")
	public ResponseEntity<Bus> DeleteBus(@Valid @PathVariable("busId") Integer busId) throws BusException{
		
		Bus bus=busService.deleteBus(busId);
		
		return new ResponseEntity<Bus>(bus,HttpStatus.OK);
	}
	
	@GetMapping("/buses")
	public ResponseEntity<List<Bus>> getAllBuses() throws BusException{
		
		List<Bus> listOfBuses=busService.viewAllBuss();
		
		return new ResponseEntity<List<Bus>>(listOfBuses,HttpStatus.OK);
	}
}
