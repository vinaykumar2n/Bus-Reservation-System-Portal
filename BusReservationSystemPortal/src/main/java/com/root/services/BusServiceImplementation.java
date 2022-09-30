package com.root.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.exceptions.BusException;
import com.root.exceptions.RouteException;
import com.root.models.Bus;
import com.root.models.Route;
import com.root.repository.BusDao;
import com.root.repository.RouteDao;

@Service
public class BusServiceImplementation implements BusService{
	
	@Autowired
	private BusDao busDao;
	
	@Autowired
	private RouteDao routeDao;

	@Override
	public Bus addBus(Bus bus) throws BusException {
		
		Route route=routeDao.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());
		
		if(bus != null) {
			route.getBusList().add(bus);
			bus.setRoute(route);
			return busDao.save(bus);
		}
		else
			throw new BusException("Bus detail is not correct");
	}

	@Override
	public Bus updateBus(Bus bus) throws BusException {
		
		Optional<Bus> existingBus=busDao.findById(bus.getBusId());
		
		if(existingBus.isPresent()) {
			Route route=routeDao.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());
			if(route == null) throw new BusException("Invalid route!");
			bus.setRoute(route);
			return busDao.save(bus);
		}
		else
			throw new BusException("Bus doesn't exist with busId : "+ bus.getBusId());

	}

	@Override
	public Bus deleteBus(int busId) throws BusException {
		
		Optional<Bus> bus=busDao.findById(busId);
		
		if(bus.isPresent()) {
			Bus existingBus = bus.get();
			busDao.delete(existingBus);
			return existingBus;
		}
		else
			throw new BusException("Bus doesn't exist with busId : "+busId);
		
	}

	@Override
	public List<Bus> viewBusByType(String BusType) throws BusException {
		List<Bus> listOfBusType = busDao.findByBusType(BusType);
		
		if(listOfBusType.size() >0)
			return listOfBusType;
		else
			throw new BusException("There is no bus of type "+ BusType);
	
	}

	@Override
	public List<Bus> viewAllBuss() throws BusException {
		
		List<Bus> buses= busDao.findAll();
		if(buses.size()>0)
			return buses;
		else
			throw new BusException("There is no bus availabe now");

	}
	
}
