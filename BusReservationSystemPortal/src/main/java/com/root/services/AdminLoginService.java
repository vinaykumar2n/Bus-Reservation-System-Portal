package com.root.services;

import com.root.DTO.AdminLoginDTO;
import com.root.exceptions.LoginException;
import com.root.models.CurrentAdminSession;

public interface AdminLoginService {
	
	public CurrentAdminSession logIntoAdminAccount(AdminLoginDTO dto)throws LoginException;

	public String logOutFromAdminAccount(String key)throws LoginException;
}
