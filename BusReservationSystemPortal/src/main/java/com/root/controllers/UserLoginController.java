package com.root.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.DTO.UserLoginDTO;
import com.root.exceptions.LoginException;
import com.root.services.UserLoginService;

@RestController
public class UserLoginController {
	
	@Autowired
	private UserLoginService userLogin;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInUser(@RequestBody UserLoginDTO dto) throws LoginException {
		
		String result = userLogin.logIntoUserAccount(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.ACCEPTED );
		
	}
	
	@PostMapping("/logout")
	public String logoutUser(@RequestParam(required = false) String key) throws LoginException {
		
		return userLogin.logOutFromUserAccount(key);
		
	}
}
