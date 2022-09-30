package com.root.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.models.Admin;
import com.root.models.AdminSession;
import com.root.models.User;
import com.root.repository.AdminDao;


@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private CurrentAdminSessionDetails currentadmin;


	public Admin createAdmin(Admin admin) {
		
		Optional<Admin> optAdmin = adminDao.findByAdminUsername(admin.getAdminUsername());
		
		
		
		   if(optAdmin.isPresent()){
			  System.out.println("Admin Already Exist"); 
		   }
		   
		   
		   
		   return adminDao.save(admin);
		
	}

	
	public Admin updateAdmin(Admin user, String key) {
		
		AdminSession admin2 = currentadmin.getcurrentAdminSessionDetails(key);
		
		if(admin2==null) {
			System.out.println("no user found");
		}
		
		return adminDao.save(user);
	}


	


	

}
