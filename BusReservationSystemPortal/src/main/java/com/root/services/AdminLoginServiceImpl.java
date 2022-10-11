package com.root.services;

import java.time.LocalDateTime;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.DTO.AdminLoginDTO;
import com.root.exceptions.LoginException;
import com.root.models.Admin;
import com.root.models.CurrentAdminSession;
import com.root.repository.AdminDao;
import com.root.repository.AdminSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;

	@Override
	public CurrentAdminSession logIntoAdminAccount(AdminLoginDTO dto) throws LoginException {

		Admin existingAdmin= adminDao.findByMobileNumber(dto.getMobileNumber());
		
		if(existingAdmin == null) throw new LoginException("Please Enter a valid mobile number!");
		
		
		Optional<CurrentAdminSession> validAdminSessionOpt =  adminSessionDao.findById(existingAdmin.getAdminId());
		
		
		if(validAdminSessionOpt.isPresent()) {
			
			throw new LoginException("Admin already Logged-In with this number");
		}
		
		if(existingAdmin.getAdminPassword().equals(dto.getAdminPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminId(),key,LocalDateTime.now());
			
			adminSessionDao.save(currentAdminSession);

			return currentAdminSession;
		}
		else
			throw new LoginException("Please Enter a valid password!");
	}

	@Override
	public String logOutFromAdminAccount(String key) throws LoginException {

		CurrentAdminSession validAdminSession = adminSessionDao.findByUuid(key);
		
		if(validAdminSession == null) {
			throw new LoginException("Admin Not Logged In with this number");
			
		}
		
		adminSessionDao.delete(validAdminSession);
		
		return "Admin Logged Out !";
	}

}
