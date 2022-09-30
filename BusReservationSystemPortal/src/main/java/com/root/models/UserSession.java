package com.root.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@Column(unique = true)
	private Integer userLoginId;
	
	
	private LocalDateTime dateTime;
	private String uuid;
	
	
	public UserSession(Integer userLoginId, LocalDateTime dateTime, String uuid) {
		super();
	
		this.userLoginId = userLoginId;
		this.dateTime = dateTime;
		this.uuid = uuid;
	}
	
	
	
	

}
