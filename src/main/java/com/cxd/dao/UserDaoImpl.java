package com.cxd.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cxd.pojo.User;

@Service("userDao")
public class UserDaoImpl implements UserDao{

	@Override
	public void showUser() {
		System.out.println("showUser in userDao");
	}

	@Override
	public void addUser(User user) {
		
	}

	@Override
	public void setUsername(User user, String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPassword(User user, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSchoolId(User user, String schoolId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEmail(User user, String emial) {
		// TODO Auto-generated method stub
		
	}
}
