package com.root.services;

import com.root.exceptions.AdminException;
import com.root.models.Admin;

public interface AdminService {
	
	public Admin createAdmin(Admin admin)throws AdminException;
	
	public Admin updateAdmin(Admin admin,String key)throws AdminException;
}
