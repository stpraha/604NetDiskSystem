package com.cxd.dao;

import com.cxd.pojo.User;

public interface UserDao {
	public void showUser();
	
	public void addUser(User user);
	
	public void setUsername(User user, String username);
	
	public void setPassword(User user, String password);
	
	public void setSchoolId(User user, String schoolId);
	
	public void setEmail(User user, String emial);
}
