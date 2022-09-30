package com.root.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.DTO.UserDTO;
import com.root.exceptions.InvalidDetailsException;
import com.root.models.User;
import com.root.models.UserSession;
import com.root.repository.UserDao;
import com.root.repository.UserSessionDao;

import net.bytebuddy.utility.RandomString;
@Service
public class UserAuthenticationImpl implements UserAuthentication{

	@Autowired
	private UserSessionDao sessionDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CurrentUserSessionDetailsImpl currentUser;
	

	
	
	public  String login(UserDTO userDTO) {

		Optional<User> opt = userDao.findByUserName(userDTO.getUserName());
		
		if(!opt.isPresent()) {
			
			throw new InvalidDetailsException("Please Check the credentials");
		}
		
		User user1 = opt.get();
		Integer userId1 = user1.getUserLoginId();
	    Optional< UserSession> currentUser =sessionDao.findByUserLoginId(userId1);
		
	   
	     if(user1.getPassword().equals(userDTO.getPassword())){
	    	
	    	String key = RandomString.make(10);
	    
	    	UserSession userSession = new UserSession(user1.getUserLoginId(),LocalDateTime.now(),key);

	          sessionDao.save(userSession);
	         
	         return userSession.toString()+" key: "+key;
	    }
	    else {
	    	throw new InvalidDetailsException("Invalid Password");
	    }
		
	}
	
	

	
	public String logOut(String key) {
		
		
		
		
		Optional<UserSession> currentUser =	sessionDao.findByUuid(key);
		
		 if(!currentUser.isPresent()) {

			 throw new InvalidDetailsException("Entered key is wrong");
		 }
		 
		 UserSession userSession =  this.currentUser.getcurrentUserSessionDetails(key);
		 
		 sessionDao.delete(userSession);

		 return "Logged Out";
		}
		
		
	}












