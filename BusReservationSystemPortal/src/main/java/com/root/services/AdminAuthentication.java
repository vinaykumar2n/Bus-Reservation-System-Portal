package com.root.services;

import com.root.DTO.AdminDTO;


public interface AdminAuthentication {

	 public  String login(AdminDTO adminDTO);
		
		public String logOut(String key);
}
