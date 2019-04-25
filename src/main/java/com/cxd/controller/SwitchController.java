package com.cxd.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cxd.pojo.User;
import com.cxd.pojo.UserFile;
import com.cxd.service.FileService;
import com.cxd.service.UserService;


@Controller
public class SwitchController {
	
	@Resource
	FileService fileService;
	
	@RequestMapping(value = "toMain.do")
    public ModelAndView toMain(HttpServletRequest request) throws Exception {
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//FileService fileService = (FileService)context.getBean("fileService");
		
		List<UserFile> publicFileList = fileService.selectAllFile();
		List<UserFile> privateFileList = fileService.selectFileByOwner("stpraha");
		
		ModelAndView mnv = new ModelAndView();
		
		//这里用addAttribute就报错了。报了个400
		mnv.addObject("publicFileList", publicFileList);
		mnv.addObject("privateFileList", privateFileList);
		//mnv.addAttribute("publicFileList", publicFileList);
		//model.addAttribute("hello", "qwerqrtryt345");
		
		//ModelAndView mv = new ModelAndView(redirect:)
		mnv.setViewName("mainPage");
		
		return mnv;
    }
	
	@RequestMapping(value = "toFile.do")
	public ModelAndView toFile(HttpServletRequest request) throws Exception {

		String id = request.getParameter("id");
		System.out.println("qwer23412   " + id );
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//FileService fileService = (FileService)context.getBean("fileService");
		
		UserFile userFile = fileService.selectByFileId(Integer.valueOf(id));
		
		ModelAndView mnv = new ModelAndView();
		
		//这里用addAttribute就报错了。报了个400
		mnv.addObject("userFile", userFile);
		//mnv.addAttribute("publicFileList", publicFileList);
		//model.addAttribute("hello", "qwerqrtryt345");
		
		//ModelAndView mv = new ModelAndView(redirect:)
		mnv.setViewName("filePage");
		
		return mnv;
	}
	
}

















