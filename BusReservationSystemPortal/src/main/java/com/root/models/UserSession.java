package com.root.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
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
public UserSession() {
	// TODO Auto-generated constructor stub
}

	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public Integer getUserLoginId() {
		return userLoginId;
	}


	public void setUserLoginId(Integer userLoginId) {
		this.userLoginId = userLoginId;
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
