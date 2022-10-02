package com.root.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.DTO.AdminDTO;
import com.root.exceptions.InvalidDetailsException;
import com.root.models.Admin;
import com.root.models.AdminSession;
import com.root.models.User;
import com.root.models.UserSession;
import com.root.repository.AdminDao;
import com.root.repository.AdminSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminAuthenticationImpl implements AdminAuthentication{
	
	@Autowired
	private AdminSessionDao sessionDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private CurrentAdminSessionDetails currentAdmin;
	
	@Override
	public String login(AdminDTO adminDTO) {
		
		Optional<Admin> optAdmin = adminDao.findByAdminUsername(adminDTO.getAdminUsername());
		
		if(!optAdmin.isPresent()) {
			throw new InvalidDetailsException("Please Check the credentials");
			}
		
		
		Admin admin1 = optAdmin.get();
		Integer adminId = admin1.getAdminId();
	    Optional< AdminSession> currentAdmin =sessionDao.findByAdminId(adminId);
		
	    
	     if(admin1.getAdminPassword().equals(adminDTO.getAdminPassword())){
	    	
	    	String key = RandomString.make(10);
	    	
	    	AdminSession adminSession = new AdminSession(admin1.getAdminId(),LocalDateTime.now(),key);

	    	sessionDao.save(adminSession);
	         System.out.println(key);
	         return adminSession.toString()+" Key is : "+key;
	    }
	    else {
	    	throw new InvalidDetailsException("Invalid Password");
	    }
		
		
	}

	@Override
	public String logOut(String key) {
System.out.println("key: "+key);
		
		Optional<AdminSession> currentAdmin =sessionDao.findByUuid(key);
		
		 if(!currentAdmin.isPresent()) {

			 throw new InvalidDetailsException("Entered key is wrong");
		 }
		 
		 AdminSession adminSession =  this.currentAdmin.getcurrentAdminSessionDetails(key);
		 
		 sessionDao.delete(adminSession);

		 return "Logged Out";
		}

}
