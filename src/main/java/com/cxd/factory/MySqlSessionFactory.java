package com.cxd.factory;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

@Service("mySqlSessionFactory")
public class MySqlSessionFactory {
	private SqlSessionFactory sqlSessionFactory;
	
	public MySqlSessionFactory() {
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e. printStackTrace();
		}
	}
	
	public SqlSession getSqlSession() {
		sqlSessionFactory.openSession();
		return sqlSessionFactory.openSession();
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
