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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.root.exceptions.RouteException;
import com.root.models.Route;
import com.root.services.RouteService;

@RestController
public class RouteController {
	
	@Autowired
	private RouteService routeService;

	@PostMapping("/route")
	public ResponseEntity<Route> addRoute(@RequestBody Route route) throws RouteException{
		
		Route newRoute= routeService.addRoute(route);
		
		return new ResponseEntity<Route>(newRoute,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/deleteRoute/{routeId}")
	public ResponseEntity<Route> DeleteRoute(@PathVariable("routeId") Integer routeId) throws RouteException{
		
		Route route = routeService.deleteRoute(routeId);
		
		return new ResponseEntity<Route>(route,HttpStatus.GONE);
	}
	
	@PutMapping("/route")
	public ResponseEntity<Route> updateRoute(@RequestBody Route route) throws RouteException{
		
		Route newRoute= routeService.updateRoute(route);
		
		return new ResponseEntity<Route>(newRoute,HttpStatus.OK);
	}
	
	@GetMapping("/routes")
	public ResponseEntity<List<Route>> getAllRoutes() throws RouteException{
		
		List<Route> routes = routeService.viewAllRoute();
		
		return new ResponseEntity<List<Route>>(routes,HttpStatus.OK);
	}

	
	@GetMapping("/route/{routeId}")
	public ResponseEntity<Route> getRouteById(@PathVariable("routeId") Integer routeId) throws RouteException{
		
		Route route = routeService.viewRoute(routeId);
		
		return new ResponseEntity<Route>(route,HttpStatus.OK);
	}
	
	
	
}
