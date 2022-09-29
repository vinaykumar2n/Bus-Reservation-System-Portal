package com.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.root.models.Route;
@Repository
public interface RouteDao extends JpaRepository<Route, Integer>{

	public Route findByRouteFromAndRouteTo(String from,String to);
}
