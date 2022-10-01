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
	
	@ExceptionHandler(FeedBackException.class)
	public ResponseEntity<Error> feedbackException(FeedBackException feedbackExc,WebRequest web){
		
		Error error = new Error(LocalDateTime.now(),feedbackExc.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<Error> routeException(AdminException adminEx,WebRequest web){
		
		Error error = new Error(LocalDateTime.now(),adminEx.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<Error> routeException(LoginException loginException,WebRequest web){
		
		Error error = new Error(LocalDateTime.now(),loginException.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ReservationException.class)
	public ResponseEntity<Error> routeException(ReservationException reservationException,WebRequest web){
		
		Error error = new Error(LocalDateTime.now(),reservationException.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<Error> routeException(UserException userException,WebRequest web){
		
		Error error = new Error(LocalDateTime.now(),userException.getMessage(), web.getDescription(false));
		
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
