package com.cxd.mapper;

import java.util.List;

import com.cxd.pojo.User;

public interface UserMapper {
	
	public List<User> selectUser(String username);
	
	public void insertUser(User user);
}
