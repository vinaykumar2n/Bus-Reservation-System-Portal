package com.root.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
public AdminSession() {
	// TODO Auto-generated constructor stub
}

	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public Integer getadminId() {
		return adminId;
	}


	public void setadminId(Integer adminId) {
		this.adminId = adminId;
	}


	public LocalDateTime getDateTime() {
		return dateTime;
	}


	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	

}
