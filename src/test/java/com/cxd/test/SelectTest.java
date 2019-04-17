package com.cxd.test;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cxd.factory.MySqlSessionFactory;
import com.cxd.mapper.UserMapper;
import com.cxd.pojo.User;


public class SelectTest {
	
	private MySqlSessionFactory mySqlSessionFactory;
	
	@Test
	public void test() {
		mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		User u = mapper.selectUser("aaakasha");
		
		System.out.println(u.getEmail());
		
		List<User> list = mapper.selectAllUser();
		
		for(User users : list) {
			System.out.println(users.getEmail());
		}
	}
}
