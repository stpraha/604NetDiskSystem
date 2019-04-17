package com.cxd.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxd.pojo.User;
import com.cxd.service.UserService;


public class UserTest {
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService userService = (UserService)context.getBean("userService");
		
		User user = userService.verifyUser("stpraha", "cxd123");
		System.out.println(user.getSchoolId());
	}
}
