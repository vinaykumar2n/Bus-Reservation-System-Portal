package com.root.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
	
	private String source;
	private String destination;
	private Integer noOfSeatsToBook;
	
	private BusDTO busDTO;
	
}
