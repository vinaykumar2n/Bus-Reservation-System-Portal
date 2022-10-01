package com.root.services;

import java.util.List;

import com.root.exceptions.AdminException;
import com.root.exceptions.BusException;
import com.root.models.Bus;

public interface BusService {

	public Bus addBus(Bus bus,String key) throws BusException, AdminException;
	
	public Bus updateBus(Bus bus,String key) throws BusException, AdminException;
	
	public Bus deleteBus(Integer busId,String key) throws BusException, AdminException;
	
	public Bus viewBus(Integer busId) throws BusException;
	
	public List<Bus> viewBusByType(String BusType) throws BusException;
	
	public List<Bus> viewAllBuses() throws BusException;
	
}
