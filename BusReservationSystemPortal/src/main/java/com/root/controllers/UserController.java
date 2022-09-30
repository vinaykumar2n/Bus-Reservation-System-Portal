package com.root.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.models.Admin;
import com.root.models.User;
import com.root.repository.UserSessionDao;
import com.root.services.AdminService;
import com.root.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	//adding user
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User user1 = userService.createUser(user);
		
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}
	
	//adding admin
		@PostMapping("/admin")
		public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
			Admin admin1 = adminService.createAdmin(admin);
			
			return new ResponseEntity<Admin>(admin1, HttpStatus.OK);
		}
	
	
	//updating user
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user, @RequestParam(required = false)String key){
	
		
        User user1 = userService.updateUser(user,key);
		
		return new ResponseEntity<User>(user1, HttpStatus.OK);	
		
	}
	
	//updating user
		@PutMapping("/admin")
		public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @RequestBody(required = false)String key){
		
			
	        Admin admin1 = adminService.updateAdmin(admin,key);
			
			return new ResponseEntity<Admin>(admin1, HttpStatus.OK);	
			
		}
		
		//delete user
		

}