package com.cxd.test;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RequTest {

	@Autowired
	HttpServletRequest request;
	
	@Test
	public void test() {
		System.out.println(request);
	}

}
