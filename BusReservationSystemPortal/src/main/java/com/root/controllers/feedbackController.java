package com.root.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.root.exceptions.BusException;
import com.root.exceptions.FeedBackException;
import com.root.exceptions.UserException;
import com.root.models.Feedback;
import com.root.services.feedbackService;


@RestController
public class feedbackController {
	
	@Autowired
	private feedbackService feedbackService;
	
	
	
	@PostMapping("/feedback/{id}/{busid}")
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback,
												@PathVariable("id") Integer uId,
												@PathVariable("busid") Integer bId) throws UserException,BusException{
		
		Feedback feedback2 = feedbackService.addFeedBack(feedback,uId,bId);
		
		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
		
	}
	
	
	
	@PostMapping("/feedback")
	public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback) throws FeedBackException {
		
		Feedback feedback2 = feedbackService.updateFeedBack(feedback);
		
		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
		
	}
	
	
//	viewFeedback
	
	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> viewFeedback(@PathVariable("id") Integer ID) throws FeedBackException {
		
		Feedback feedback2 = feedbackService.viewFeedback(ID);
		
		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/feedback")
	public ResponseEntity<List<Feedback>> viewFeedbackAll() throws FeedBackException {
		
		List<Feedback> feedback2 =  feedbackService.viewFeedbackAll();
		
		return new ResponseEntity<List<Feedback>>(feedback2,HttpStatus.ACCEPTED);
		
	}
	
}
