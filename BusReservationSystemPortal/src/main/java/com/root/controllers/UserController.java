package com.root.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.root.models.User;
import com.root.repository.UserSessionDao;
import com.root.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User user1 = userService.createUser(user);
		
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}
	
	@PutMapping("/user")
	public ResponseEntity<User>  updateUser(@RequestBody User user){
	
		
        User user1 = userService.updateUser(user);
		
		return new ResponseEntity<User>(user1, HttpStatus.OK);	
		
	}

}
