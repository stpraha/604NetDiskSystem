package com.cxd.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cxd.pojo.UserFile;
import com.cxd.service.FileService;

public class FileUtil {
	public static void deleteByPath(String filePath) {
		File file = new File(filePath);
		System.out.println("delete file" + filePath);
		if(file.exists() && file.isFile()) {
			file.delete();
		}
	}
	
	public static String getFileStoreName(String filename, int fileSize, String fileOwner) {
		
		String fileStoreName = fileOwner + fileSize + filename;
		
		return fileStoreName;
		
	}
}
