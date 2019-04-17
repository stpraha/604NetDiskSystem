package com.cxd.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cxd.pojo.User;

@Repository
public interface UserMapper {
	
	public User selectUser(String username);
	
	public void insertUser(User user);
	
	public List<User> selectAllUser();	
}
