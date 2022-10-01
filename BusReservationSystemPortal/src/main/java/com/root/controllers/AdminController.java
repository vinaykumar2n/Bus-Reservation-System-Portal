package com.root.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.exceptions.AdminException;
import com.root.models.Admin;
import com.root.services.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) throws AdminException {
		
		Admin savedAdmin= adminService.createAdmin(admin);
		
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.CREATED);
	}
	
	@PutMapping("/admin")
	public  ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin,@RequestParam(required = false) String key ) throws AdminException {
		
		Admin updatedAdmin= adminService.updateAdmin(admin, key);
				
		return new ResponseEntity<Admin>(updatedAdmin,HttpStatus.OK);
		
	}
}
