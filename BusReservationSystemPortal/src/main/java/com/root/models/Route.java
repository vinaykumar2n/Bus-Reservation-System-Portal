package com.root.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;
	
	@NotBlank(message = "RouteFrom can't be blank")
	@NotEmpty(message = "RouteFrom can't be empty")
	private String routeFrom;
	
	@NotBlank(message = "RouteTo can't be blank")
	@NotEmpty(message = "RouteTo can't be empty")
	private String routeTo;
	
	@Min(value = 100,message = "Distance can't be less than 100")
	@NotNull(message = "Distance can't be null")
	private Integer distance;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "route")
	private List<Bus> busList = new ArrayList<>();
	
}
