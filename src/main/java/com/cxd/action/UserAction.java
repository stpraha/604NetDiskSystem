package com.cxd.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxd.service.UserService;

@Service("userAction")
public class UserAction {
	
	@Autowired
	private UserService userService;
	
	public String showUser() {
		System.out.println("you got here");
		this.userService.showUser();
		
		return "ok";
	}
}
