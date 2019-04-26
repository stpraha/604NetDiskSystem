package com.cxd.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Resource
	HttpServletRequest request;
	
	@Resource
	UserService userService;
	
	@Resource
	HttpSession session;
	
    @RequestMapping("login.do")
    public String login() {
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//UserService userService = (UserService)context.getBean("userService");
		//HttpSession session = request.getSession();
		System.out.println(request.getContentLength() + "test");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userService.verifyUser(username, password);
    	
        if(user == null || !user.getUsername().equals(username)) {
        	System.out.println("login failed");
        	return "register";
        }
        else {
        	session.setAttribute("CURRENT_USER", user.getUsername());
        	System.out.println(" 登录成功" + username);
            return "redirect:toMain.do";
        }
    }
    
    @RequestMapping("logout.do")
    public String logout() {
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//UserService userService = (UserService)context.getBean("userService");
		//HttpSession session = request.getSession();
    	String username = (String) session.getAttribute("CURRENT_USER");
    	
        if(username == null || username.equals("")) {
        	return "login";
        }
        else {
        	System.out.println(username + "  logout");
        	session.removeAttribute("CURRENT_USER");
        	System.out.println(session.getAttribute("test  " + "CURRENT_USER"));
            return "redirect:toMain.do";
        }
    }
    
    @RequestMapping("register.do")
    public String register(String username, String password, String confirm_password, String school_id, String email) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//UserService userService = (UserService)context.getBean("userService");
		
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
