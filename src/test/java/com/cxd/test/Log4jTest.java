package com.cxd.test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Log4jTest {
	
	private static final Logger logger = LogManager.getLogger(com.cxd.service.UserService.class);

	@Test
	public void TestLog4j() {
		
		System.out.println(Log4jTest.class);
		
		//Logger logger = LogManager.getLogger("AsyncFileLogger");
		
		//String rootPath = "E:\\Eclipse\\eclipse-workspace\\NetDisk";
		//session.getServletContext().getRealPath("/previewPic/") + "/";
		
		//System.setProperty("log.base", rootPath);
		
		//PropertyConfigurator.configure("log4j.properties");
		
		logger.trace("This is trace message.");
		logger.debug("This is debug message.");
		logger.info("This is info message.");
		logger.warn("warning");
		logger.error("This is error message.");
		
		
	
	
	
	}
}