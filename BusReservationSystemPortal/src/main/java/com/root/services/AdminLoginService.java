package com.root.services;

import com.root.DTO.AdminLoginDTO;
import com.root.exceptions.LoginException;

public interface AdminLoginService {
	
	public String logIntoAdminAccount(AdminLoginDTO dto)throws LoginException;

	public String logOutFromAdminAccount(String key)throws LoginException;
}
