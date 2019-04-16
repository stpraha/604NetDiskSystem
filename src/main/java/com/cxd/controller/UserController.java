package com.cxd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cxd.pojo.User;


@Controller
public class UserController {
    @RequestMapping("login.do")
    public String login(String username, String password) {
    	System.out.println(username);
        if ("admol".equals(username)) {
            System.out.println(" 登录成功" + username);
            return "loginSuccess";
        }
        //System.out.println("/page/loginError.jsp");
        return "register";
    }
    
    @RequestMapping("register.do")
    public String register(String username, String password, String confirm_password, String school_id, String email) {
    	System.out.println("点了注册" + username + password + confirm_password + school_id + email);
    	return "register";
    }
	
}
