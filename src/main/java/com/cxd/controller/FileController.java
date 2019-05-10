package com.cxd.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cxd.pojo.*;
import com.cxd.service.FileService;
import com.cxd.service.UserService;
import com.cxd.utils.FileUtil;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	private static final Logger logger = LogManager.getLogger(FileController.class);
	
	@Resource
	FileService fileService;
	
	@Resource
	HttpServletRequest request;
	
	@Resource
	HttpServletResponse response;
	
	@Resource
	UserService userService;
	
	@Resource
	HttpSession session;
	
	
	
	@RequestMapping("checkFileMD5.do")
	//@ResponseBody
	public Object checkFileMD5(String md5) throws IOException {
		
		
		
		return md5;
	}
	
	@RequestMapping("upload.do")
	public ResponseEntity upLoad(@RequestParam("file")MultipartFile files) throws Exception {
		
		String user = (String) session.getAttribute("CURRENT_USER");	
		//System.out.println("Used! what to do next??>>");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart) {
			//System.out.println("start upload");
			try {
				String filename = files.getOriginalFilename();
				int fileSize = (int) files.getSize();
				String fileOwner = (String) session.getAttribute("CURRENT_USER");
				
				String fileStoreName = FileUtil.getFileStoreName(filename, fileSize, fileOwner);
				
				String path = "E:\\Eclipse\\UploadFiles\\" + fileStoreName;
				File uploadFile = new File(path);
				files.transferTo(uploadFile);
				
				boolean fileVisibility = false;
				
				String fileLoc = "E:\\Eclipse\\UploadFiles\\" + fileStoreName;
				
				saveToSql(filename, fileSize, fileOwner, fileVisibility, fileLoc, fileStoreName);
				logger.info("用户 " + fileOwner + " 上传文件  " + filename + " 成功!");
				
			} catch (Exception e) {
				logger.error("用户 " + user + " 上传文件发生异常： " + e);
				e.printStackTrace();
			}
			System.out.println("finish upload");
		}
		
		return ResponseEntity.ok().body("上传成功");
	}
	
	private void saveToSql(String fileName, int fileSize, String fileOwner, boolean fileVisibility, String fileLoc, String fileStoreName) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//FileService fileService = (FileService)context.getBean("fileService");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fileTime = sdf.format(new Date());
		
		if(fileOwner == null || fileOwner.equals("")) fileOwner = "Public";
		
		UserFile userFile = new UserFile(666, fileName, fileSize, fileTime, fileOwner, fileVisibility, fileLoc, fileStoreName);
		
		fileService.addFile(userFile);
		
	}
	
	@RequestMapping("download.do")
	public String downloadFile() throws Exception {
		String idStr = request.getParameter("id");

		int id = Integer.valueOf(idStr);
		String username = (String) session.getAttribute("CURRENT_USER");
		
		System.out.println(username + " download file " + idStr);
		
		UserFile downloadFile = fileService.selectByFileId(id);
		
		if(username == null || username.equals("")) {
			logger.info("用户 " + username + " 下载文件" + downloadFile.getFileName() + "失败: 用户未登录!");
			return "/page/login.jsp";
		}
		else if(downloadFile == null) {
			System.out.println("file not found");
			logger.info("用户 " + username + " 下载文件" + downloadFile.getFileName() + "失败: 文件不存在！");
			return "redirect:toMain.do";
		}
		else if(!downloadFile.isFileVisibility() && !downloadFile.getFileOwner().equals(username)) {
			System.out.println(downloadFile.isFileVisibility());
			//System.out.println();
			logger.info("用户 " + username + " 下载文件" + downloadFile.getFileName() + "失败： 权限未通过！");
			return "redirect:toMain.do";
		}
		else {
			logger.info("用户 " + username + " 下载文件" + downloadFile.getFileName() + "验证通过！");
			return "redirect:downloadFile.do?id=" + id;
		}

	}
	
	@RequestMapping("downloadFile.do")
	public ResponseEntity download( ) throws Exception {
		String idStr = request.getParameter("id");
		int id = Integer.valueOf(idStr);
		String username = (String) session.getAttribute("CURRENT_USER");
		System.out.println(username + " download file " + idStr);
		UserFile downloadFile = fileService.selectByFileId(id);
		String filePath = downloadFile.getFileLoc();
		String fileName = downloadFile.getFileName();
		
		
		//下面的用来下载文件

		ServletContext servletContext = request.getServletContext();
		File file = new File(filePath);
		InputStream inputStream = new FileInputStream(file);
		byte[] body = new byte[inputStream.available()];
		inputStream.read(body);
		
		fileName = new String(fileName.getBytes("gbk"),"iso8859-1");
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename="+fileName);
		
		HttpStatus statusCode=HttpStatus.OK;
		 
        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body,headers,statusCode);
        
        logger.info("用户 " + username + " 下载文件" + downloadFile.getFileName() + "开始下载！");
        return response;
	}
	
	@RequestMapping("delete.do")
	public String deleteFile() throws Exception {
		String idStr = request.getParameter("id");
		int id = Integer.valueOf(idStr);
		
		UserFile file = fileService.selectByFileId(id);
		
		String username = (String) session.getAttribute("CURRENT_USER");
		
		if(file.getFileOwner().equals(username)) {
			fileService.deleteFileByFileId(id);
			logger.info("用户 " + username + " 删除文件 " + file.getFileName());
			return "redirect:toManage.do";
		}
		else {
			logger.info("用户 " + username + " 删除文件 " + file.getFileName() + " 失败：验证未通过！");
			return "redirect:/page/login.jsp";
		}
	}
	
	@RequestMapping("switchVisibility.do")
	public String switchVisibility() throws Exception {
		String idStr = request.getParameter("id");
		
		String visibility = request.getParameter("visibility");
		
		int id = Integer.valueOf(idStr);
		
		UserFile file = fileService.selectByFileId(id);
		
		
		String username =  (String) session.getAttribute("CURRENT_USER");
		
		if(file.getFileOwner().equals(username)) {
			if(visibility.equals("true")) {
				fileService.changeFileVisibilityFalse(id);
				logger.info("用户 " + username + " 将文件 " + file.getFileName() + " 设为私密");
			}
			else if(visibility.equals("false")) {
				fileService.changeFileVisibilityTrue(id);
				logger.info("用户 " + username + " 将文件 " + file.getFileName() + " 设为公开");
			}
		}
		else {
			logger.info("用户 " + username + " 修改文件公开性 " + file.getFileName() + " 失败：验证未通过！");
			return "redirect:/page/login.jsp";
		}
		
		return "redirect:toManage.do";
	}
}

