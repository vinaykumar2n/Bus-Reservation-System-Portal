package com.root.services;

import com.root.models.Admin;


public interface AdminService{
	public Admin createAdmin(Admin admin);

	public Admin updateAdmin(Admin admin, String key);
}
