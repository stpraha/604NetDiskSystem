package com.cxd.factory;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

@Service("sqlSessionFactory")
public class MySqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("wqerqwerqwerqwe11111111");
		} catch (Exception e) {
			e. printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		sqlSessionFactory.openSession();
		System.out.println("wqerqwerqwerqwe");
		
		return sqlSessionFactory.openSession();
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	
}
