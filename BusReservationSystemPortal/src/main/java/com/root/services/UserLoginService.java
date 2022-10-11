package com.root.services;

import com.root.DTO.UserLoginDTO;
import com.root.exceptions.LoginException;
import com.root.models.CurrentUserSession;

public interface UserLoginService {
	
	public CurrentUserSession logIntoUserAccount(UserLoginDTO dto)throws LoginException;

	public String logOutFromUserAccount(String key)throws LoginException;
}
