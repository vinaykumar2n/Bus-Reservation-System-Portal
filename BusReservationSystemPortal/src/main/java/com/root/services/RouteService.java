package com.root.services;

import java.util.List;

import com.root.exceptions.AdminException;
import com.root.exceptions.RouteException;
import com.root.models.Route;

public interface RouteService {

	public Route addRoute(Route route,String key) throws RouteException, AdminException;
	
	public Route updateRoute(Route route,String key) throws RouteException, AdminException;
	
	public Route deleteRoute(int routeId,String key) throws RouteException, AdminException;
	
	public Route viewRoute(int routeId) throws RouteException;
	
	public List<Route> viewAllRoute() throws RouteException;
	
	
}
