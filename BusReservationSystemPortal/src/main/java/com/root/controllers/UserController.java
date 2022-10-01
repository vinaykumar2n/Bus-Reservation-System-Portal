package com.root.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.exceptions.AdminException;
import com.root.exceptions.UserException;
import com.root.models.User;
import com.root.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) throws UserException {
		
		User savedUser= userService.createUser(user);
		
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/users")
	public  ResponseEntity<User> updateUser(@Valid @RequestBody User user,@RequestParam(required = false) String key ) throws UserException {
		
		User updatedUser= userService.updateUser(user, key);
				
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/users/admin/{userId}")
	public  ResponseEntity<User> deleteUser(@PathVariable("userId") Integer userId ,@RequestParam(required = false) String key ) throws UserException, AdminException {
		
		User deletedUser= userService.deleteUser(userId, key);
				
		return new ResponseEntity<User>(deletedUser,HttpStatus.OK);
		
	}
	
	@GetMapping("/users/admin/{userId}")
	public  ResponseEntity<User> viewUser(@PathVariable("userId") Integer userId ,@RequestParam(required = false) String key ) throws UserException, AdminException {
		
		User user= userService.viewUserById(userId, key);
				
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
	@GetMapping("/users/admin")
	public  ResponseEntity<List<User>> viewAllUser(@RequestParam(required = false) String key ) throws UserException, AdminException {
		
		List<User> userList= userService.viewUsers(key);
				
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
		
	}
	
	
}
