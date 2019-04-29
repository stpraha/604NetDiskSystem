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
	    	String message = "?message=loginfailed";
			return "redirect:/page/login.jsp" + message;
        }
        else {
        	session.setAttribute("CURRENT_USER", user.getUsername());
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
		
		boolean canRegister = RegisterUtil.checkNull(username, password, confirm_password, school_id, email);
		
		boolean usernameCheck = userService.checkUser(username);
		
		boolean admin = false;
		
		if(canRegister && usernameCheck) {
			User user = new User(1, username, password, school_id, email, admin);
	    	System.out.println("点了注册" + username + password + confirm_password + school_id + email);
	    	userService.addUser(user);
	    	return "redirect:login.do";
		}
		else {
	    	String message = "?message=registerfailed";
			if(!userService.checkUser(username)) {
				message = message + "&errorMessage=idUsed";
			}
			else if(!canRegister) {
				message = message + "&errorMessage=inputError";
			}
			return "redirect:/page/register.jsp" + message;
		}
    }
}
