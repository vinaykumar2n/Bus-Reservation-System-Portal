package com.root.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.models.User;
import com.root.models.UserSession;
import com.root.repository.UserDao;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private CurrentUserSessionDetails currentuser;


	public User createUser(User user) {
		
		Optional<User> opt = userDao.findByUserName(user.getUserName());
		
		
		
		   if(opt.isPresent()){
			  System.out.println("User Already Exist"); 
		   }
		   
		   
		   
		   return userDao.save(user);
		
	}

	
	public User updateUser(User user, String key) {
		
		UserSession user2 = currentuser.getcurrentUserSessionDetails(key);
		
		if(user2==null) {
			System.out.println("no user found");
		}
		
		return userDao.save(user);
	}


	

}
