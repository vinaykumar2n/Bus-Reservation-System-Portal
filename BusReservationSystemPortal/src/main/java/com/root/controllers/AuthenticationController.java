package com.root.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.DTO.UserDTO;
import com.root.models.UserSession;
import com.root.services.UserAuthentication;
import com.root.services.UserService;

@RestController
public class AuthenticationController {
	
	@Autowired
	private UserAuthentication userLogin;

	@PostMapping("/login")
	public ResponseEntity<String> customerLogin(@RequestBody UserDTO userDTO) {
		
		  String userSession =  userLogin.login(userDTO);
		  System.out.println("Logged in ...");
		  
		  return new ResponseEntity<String>(userSession,HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/logout")
	public ResponseEntity<String> customerLogout(@RequestParam(required = false) String key) {
		
		  
			
		  String user =  userLogin.logOut(key);
		  
		  return new ResponseEntity<String>(user,HttpStatus.ACCEPTED);
	}
	
	

}
          