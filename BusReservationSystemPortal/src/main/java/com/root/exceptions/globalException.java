package com.root.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Error> validatedException(MethodArgumentNotValidException validE,WebRequest web){
		
		Error error = new Error(LocalDateTime.now(),validE.getMessage(),validE.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BusException.class)
	public ResponseEntity<Error> busException(BusException buse,WebRequest web){
		
		Error error = new Error(LocalDateTime.now(),buse.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RouteException.class)
	public ResponseEntity<Error> routeException(RouteException routeE,WebRequest web){
		
		Error error = new Error(LocalDateTime.now(),routeE.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Error> noHandler(NoHandlerFoundException nohandler,WebRequest web){
		
		Error error = new Error(LocalDateTime.now(),nohandler.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> exception(Exception e,WebRequest web){ 
		
		Error error = new Error(LocalDateTime.now(),e.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.EXPECTATION_FAILED);
	}
		
}
