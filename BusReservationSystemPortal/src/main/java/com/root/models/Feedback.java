package com.root.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Feedback {
	
	public Integer getFeedBackId() {
		return feedBackId;
	}



	public void setFeedBackId(Integer feedBackId) {
		this.feedBackId = feedBackId;
	}



	public Integer getDriverRating() {
		return driverRating;
	}



	public void setDriverRating(Integer driverRating) {
		this.driverRating = driverRating;
	}



	public Integer getServiceRating() {
		return serviceRating;
	}



	public void setServiceRating(Integer serviceRating) {
		this.serviceRating = serviceRating;
	}



	public Integer getOverallRating() {
		return overallRating;
	}



	public void setOverallRating(Integer overallRating) {
		this.overallRating = overallRating;
	}



	public String getComments() {
		return comments;
	}



	public void setComments(String comments) {
		this.comments = comments;
	}



	public LocalDateTime getFeedbackdate() {
		return feedbackdate;
	}



	public void setFeedbackdate(LocalDateTime feedbackdate) {
		this.feedbackdate = feedbackdate;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Bus getBus() {
		return bus;
	}



	public void setBus(Bus bus) {
		this.bus = bus;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedBackId;
	private Integer driverRating;
	private Integer serviceRating;
	private Integer overallRating;
	private String comments;
	private LocalDateTime feedbackdate = LocalDateTime.now();
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Bus bus;
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Feedback(Integer feedBackId, Integer driverRating, Integer serviceRating, Integer overallRating,
			String comments, User user, Bus bus) {
		super();
		this.feedBackId = feedBackId;
		this.driverRating = driverRating;
		this.serviceRating = serviceRating;
		this.overallRating = overallRating;
		this.comments = comments;
		this.user = user;
		this.bus = bus;
	}




	
	
}
