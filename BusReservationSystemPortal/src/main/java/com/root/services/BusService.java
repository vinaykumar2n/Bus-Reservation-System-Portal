package com.root.services;

import java.util.List;
import java.util.Set;

import com.root.exceptions.BusException;
import com.root.exceptions.RouteException;
import com.root.models.Bus;

public interface BusService {

	public Bus addBus(Bus bus) throws BusException;
	
	public Bus updateBus(Bus bus) throws BusException;
	
	public Bus deleteBus(int busId) throws BusException;
	
	public List<Bus> viewBusByType(String BusType) throws BusException;
	
	public List<Bus> viewAllBuss() throws BusException;
	
}
