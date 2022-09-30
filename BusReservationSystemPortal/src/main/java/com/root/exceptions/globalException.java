package com.root.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class globalException {

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<myErrorDetail> exception(Exception e,WebRequest req) {
		
		myErrorDetail err = new myErrorDetail();
		err.setTime(LocalDateTime.now());
		err.setMsg(e.getMessage());
		err.setDes(req.getDescription(false));
		
		return new ResponseEntity<myErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
}
