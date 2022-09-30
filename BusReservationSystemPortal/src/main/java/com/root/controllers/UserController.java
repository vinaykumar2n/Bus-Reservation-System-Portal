package com.root.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.exceptions.UserException;
import com.root.models.User;
import com.root.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody User user) throws UserException {
		
		User savedUser= userService.createUser(user);
		
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/users")
	public  ResponseEntity<User> updateUser(@RequestBody User user,@RequestParam(required = false) String key ) throws UserException {
		
		User updatedCustomer= userService.updateUser(user, key);
				
		return new ResponseEntity<User>(updatedCustomer,HttpStatus.OK);
		
	}
}
