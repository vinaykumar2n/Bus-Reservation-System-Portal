package com.root.models;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId;
	private String busName;
	private String driverName;
	private String busType;
	private String routeFrom;
	private String routeTo;
	@JsonFormat(pattern="HH:mm")
	private LocalTime arrivalTime;
	@JsonFormat(pattern="HH:mm")
	private LocalTime departureTime;
	private Integer seats;
	private Integer availableSeats;
	private Integer farePerSeat;
	
	@ManyToOne
	private Route route;
	
	
}
