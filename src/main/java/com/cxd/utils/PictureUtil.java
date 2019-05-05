package com.cxd.utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.cxd.pojo.UserFile;

import net.coobird.thumbnailator.Thumbnails;

public class PictureUtil {
	public synchronized static String previewPicGenerator(UserFile userFile, String path) throws Exception{

		String fileStoreName = userFile.getFileStoreName();
		String filePath = userFile.getFileLoc();
		File file = new File(filePath);
		
		//处理缩略图名称
//		byte[] bytes = fileName.getBytes("UTF-8");
//		String byteFileName = "";
//		for(byte b: bytes) {
//			byteFileName = byteFileName + "%" + String.format("%02X", b);
//		}
//		byteFileName = byteFileName + ".jpg"; 
//		System.out.println(byteFileName);
		
		String previewFileName = "preview" + fileStoreName + ".jpg";

		String previewFilePath = path + previewFileName;
		//System.out.println("aa " + previewFilePath) ;
		File previewFile = new File(previewFilePath);
		
		//取得原始图像
		BufferedImage bufferedImage = ImageIO.read(file);
		
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		
		int previewWidth = Math.min(width, 400);
		int previewHeight = Math.min(height, previewWidth * width / height);
		
		Thumbnails.of(bufferedImage).size(previewWidth, previewHeight).toFile(previewFile);

		
		return previewFileName;
	}
}









