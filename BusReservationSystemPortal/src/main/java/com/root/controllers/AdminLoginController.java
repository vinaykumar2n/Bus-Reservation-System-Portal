package com.root.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.DTO.AdminLoginDTO;
import com.root.exceptions.LoginException;
import com.root.models.CurrentAdminSession;
import com.root.services.AdminLoginService;

@RestController
public class AdminLoginController {
	
	@Autowired
	private AdminLoginService adminLogin;
	
	@PostMapping("/login/admin")
	public ResponseEntity<CurrentAdminSession> logInAdmin(@Valid @RequestBody AdminLoginDTO dto) throws LoginException {
		
		CurrentAdminSession result = adminLogin.logIntoAdminAccount(dto);
		
		return new ResponseEntity<CurrentAdminSession>(result,HttpStatus.ACCEPTED );
		
	}
	
	@PostMapping("/logout/admin")
	public String logoutAdmin(@RequestParam(required = false) String key) throws LoginException {
		
		return adminLogin.logOutFromAdminAccount(key);
		
	}
}
