package com.root.services;

import java.util.List;

import com.root.exceptions.FeedBackException;
import com.root.models.Feedback;


public interface feedbackService {
	
	
	public Feedback addFeedBack(Feedback feedBack,Integer uid,Integer bid) throws busException, userException;
	
	public Feedback updateFeedBack(Feedback feedback) throws FeedBackException;

	public Feedback viewFeedback(Integer id) throws FeedBackException;

	public List<Feedback> viewFeedbackAll() throws FeedBackException;
	
}
