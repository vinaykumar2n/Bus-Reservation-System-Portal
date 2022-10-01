package com.root.services;

import com.root.DTO.UserLoginDTO;
import com.root.exceptions.LoginException;

public interface UserLoginService {
	
	public String logIntoUserAccount(UserLoginDTO dto)throws LoginException;

	public String logOutFromUserAccount(String key)throws LoginException;
}
