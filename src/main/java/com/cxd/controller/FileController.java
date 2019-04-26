package com.cxd.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
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
	
	@Resource
	FileService fileService;
	
	@Resource
	HttpServletRequest request;
	
	@Resource
	UserService userService;
	
	@Resource
	HttpSession session;
	
	@RequestMapping("upload.do")
	public ResponseEntity upLoad(@RequestParam("file")MultipartFile files) throws Exception {
		
		String user = (String) session.getAttribute("CURRENT_USER");	
		System.out.println("Used! what to do next??>>");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart) {
			System.out.println("start upload");
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
				
			} catch (Exception e) {
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
	
	
//	@RequestMapping("download.do")
//	public String downloadFile(HttpServletResponse response, HttpSession httpSession, HttpServletRequest request,  
//			@RequestParam(value="name") String name, 
//			@RequestParam(value="originalName") String originalName, 
//			@RequestParam(value="path") String path) {
//		
//		try {
//			String local = request.getSession().getServletContext().getRealPath("/downloadFile/");
//			String myFile = local + originalName;
//			if(!new java.io.File(myFile).exists()){
//				java.io.File realPath = new java.io.File(local);
//				if(!realPath.exists()) {
//					realPath.mkdirs();
//				}
//				if(fileService.downloadFile(user, file, myFile)) {
//					result.put("errres", true);
//					result.put("errmsg", "涓嬭浇鎴愬姛锛�");
//					result.put("url", "downloadFile\\" + originalName);
//				}else {
//					result.put("errres", false);
//					result.put("errmsg", "鏂囦欢涓嶅瓨鍦紒");
//				}
//			}else {
//				result.put("errres", true);
//				result.put("errmsg", "鏂囦欢宸茬粡瀛樺湪锛�");
//				result.put("url", "downloadFile\\" + originalName);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		ResponseUtil.write(response, result);
//		return null;
//	}	
	
	@RequestMapping("delete.do")
	public String deleteFile() throws Exception {
		String idStr = request.getParameter("id");
		int id = Integer.valueOf(idStr);
		
		UserFile file = fileService.selectByFileId(id);
		
		if(file.getFileOwner().equals(session.getAttribute("CURRENT_USER"))) {
			fileService.deleteFileByFileId(id);
			return "redirect:toManage.do";
		}
		else {
			return "redirect:/page/login.jsp";
		}
	}
}












