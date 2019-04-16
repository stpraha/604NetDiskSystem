package com.cxd.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxd.action.UserAction;

public class UserTest {
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserAction userAction = (UserAction) context.getBean("userAction");
		String str = userAction.showUser();
		System.out.println(str);
	}
}
