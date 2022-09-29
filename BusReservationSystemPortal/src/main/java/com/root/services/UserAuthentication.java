package com.root.services;

import com.root.DTO.UserDTO;
import com.root.models.UserSession;

public interface UserAuthentication {
	
   public  String login(UserDTO userDTO);
	
	public String logOut(String key);

}
