package com.cxd.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxd.pojo.User;
import com.cxd.service.UserService;
import com.cxd.utils.RegisterUtil;

@Controller
public class UserController {

//	@Autowired
//	UserService userService;
	
    @RequestMapping("login.do")
    public String login(String username, String password) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)context.getBean("userService");
		
		User user = userService.verifyUser(username, password);
    	
        if(user == null || !user.getUsername().equals(username)) {
        	System.out.println("login failed");
        	return "register";
        }
        else {
        	System.out.println(" 登录成功" + username);
            return "loginSuccess";
        }
    }
    
    @RequestMapping("register.do")
    public String register(String username, String password, String confirm_password, String school_id, String email) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)context.getBean("userService");
		
		boolean canRegister = RegisterUtil.checkNull(username, password, confirm_password, school_id, email) & 
							  userService.checkUser(username);
		if(canRegister) {
			User user = new User(1, username, password, school_id, email);
	    	System.out.println("点了注册" + username + password + confirm_password + school_id + email);
	    	userService.addUser(user);
	    	return "loginSuccess";
		}
		else return "register";
    }
}
