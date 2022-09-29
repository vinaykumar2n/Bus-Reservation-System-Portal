package com.root.services;

import java.util.List;

import com.root.exceptions.RouteException;
import com.root.models.Route;

public interface RouteService {

	public Route addRoute(Route route) throws RouteException;
	
	public Route updateRoute(Route route) throws RouteException;
	
	public Route deleteRoute(int routeId) throws RouteException;
	
	public Route viewRoute(int routeId) throws RouteException;
	
	public List<Route> viewAllRoute() throws RouteException;
	
	
}
