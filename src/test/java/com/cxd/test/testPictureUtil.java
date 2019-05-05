package com.cxd.test;

import static org.junit.Assert.*;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.cxd.factory.MySqlSessionFactory;
import com.cxd.pojo.UserFile;
import com.cxd.service.FileService;
import com.cxd.utils.PictureUtil;
import com.cxd.mapper.*;

public class testPictureUtil {
	private MySqlSessionFactory mySqlSessionFactory;
	
	
	@Test
	public void test() throws Exception {
		
		String test = "900";
		byte[] b = test.getBytes("UTF-8");
		
		
		for(byte bb: b) {
			System.out.print(String.format("%02X", bb));
		}
		System.out.println(b.toString());
		

	}

}
