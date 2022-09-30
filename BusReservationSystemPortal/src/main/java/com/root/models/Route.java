package com.root.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Min(value = 1,message = "value should be minnimum 1 or greater than 1")
	private Integer routeId;
	private String routeFrom;
	private String routeTo;
	private Integer distance;
	
	@JsonIgnore
	@OneToMany
	private List<Bus> busList;
		
}
