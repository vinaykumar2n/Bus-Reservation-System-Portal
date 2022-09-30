package com.root.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdminSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@Column(unique = true)
	private Integer adminId;
	
	
	private LocalDateTime dateTime;
	private String uuid;
	
	
	public AdminSession(Integer adminId, LocalDateTime dateTime, String uuid) {
		super();
	
		this.adminId = adminId;
		this.dateTime = dateTime;
		this.uuid = uuid;
	}
	
	
	

}
