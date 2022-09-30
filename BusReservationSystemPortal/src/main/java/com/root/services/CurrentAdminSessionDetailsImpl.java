package com.root.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.models.AdminSession;
import com.root.repository.AdminSessionDao;

@Service
public class CurrentAdminSessionDetailsImpl  implements CurrentAdminSessionDetails{
	@Autowired
	private AdminSessionDao sessionDao;
	
	public AdminSession getcurrentAdminSessionDetails(String key) {
		
		
		Optional<AdminSession>  opt = sessionDao.findByUuid(key);
		
		   if(!opt.isPresent()) {
			   System.out.println("unauthorized");
		   }
		   
		   return opt.get();
		
		
		
		
	}

}
