package com.cxd.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxd.pojo.*;
import com.cxd.service.FileService;
import com.cxd.service.UserService;

import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class FileController {
	
	@RequestMapping("upload.do")
	public void springUpLoad(HttpServletRequest request) 
			throws IllegalStateException, IOException {
		//将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		//检查form中是否有enctype="multipart/form-data"
		if(multipartResolver.isMultipart(request)) {
			//将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			Iterator iter = multiRequest.getFileNames();
			
			while(iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if(file != null) {
					String path = "E:\\Eclipse\\UploadFiles\\" + file.getOriginalFilename();
					//上传
					file.transferTo(new File(path));
					saveToSql(file.getOriginalFilename(), (int)file.getSize(), "stpraha", true, path);
				}
			}
		}
	}
	
	private void saveToSql(String fileName, int fileSize, String fileOwner, boolean fileVisibility, String fileLoc) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		FileService fileService = (FileService)context.getBean("fileService");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fileTime = sdf.format(new Date());
		UserFile userFile = new UserFile(666, fileName, fileSize, fileTime, fileOwner, fileVisibility, fileLoc);
		
		fileService.addFile(userFile);
		
	}
	
	
	@RequestMapping("download.do")
	public String downloadFile(HttpServletResponse response, HttpSession httpSession, HttpServletRequest request,  
			@RequestParam(value="name") String name, 
			@RequestParam(value="originalName") String originalName, 
			@RequestParam(value="path") String path) {
		JSONObject result = new JSONObject();
		User user = new User();
		user.setName(name);
		File file = new File();
		file.setOriginalName(originalName);
		file.setPath(path);
		try {
			String local = request.getSession().getServletContext().getRealPath("/downloadFile/");
			String myFile = local + originalName;
			if(!new java.io.File(myFile).exists()){
				java.io.File realPath = new java.io.File(local);
				if(!realPath.exists()) {
					realPath.mkdirs();
				}
				if(fileService.downloadFile(user, file, myFile)) {
					result.put("errres", true);
					result.put("errmsg", "下载成功！");
					result.put("url", "downloadFile\\" + originalName);
				}else {
					result.put("errres", false);
					result.put("errmsg", "文件不存在！");
				}
			}else {
				result.put("errres", true);
				result.put("errmsg", "文件已经存在！");
				result.put("url", "downloadFile\\" + originalName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseUtil.write(response, result);
		return null;
	}
}












