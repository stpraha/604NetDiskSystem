package com.cxd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxd.pojo.User;
import com.cxd.pojo.UserFile;
import com.cxd.service.FileService;
import com.cxd.service.UserService;

@Controller
public class SwitchController {
	
	@RequestMapping("toMain.do")
    public String toMain(HttpServletRequest request, HttpServletResponse response) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		FileService fileService = (FileService)context.getBean("fileService");
		
		List<UserFile> fileList = fileService.selectAllFile();
		
		for(UserFile file :fileList) {
			System.out.println(file.getFileName());
		}
		
		return "login";
    }
	
}

















