package com.cxd.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;

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
	
	public static String getFileStoreName(String fileName, int fileSize, String fileOwner) throws UnsupportedEncodingException {
		
		String fileNameEncode = "";
		byte[] bytes = fileName.getBytes("UTF-8");
		
		
		for(byte b: bytes) {
			fileNameEncode = fileNameEncode + String.format("%02X", b);
		}

		//String fileNameEncode = new String(fileName.getBytes("utf-8"), "GBK");
		
		String fileStoreName = fileOwner + fileSize + fileNameEncode;
		
		return fileStoreName;
		
	}
}
