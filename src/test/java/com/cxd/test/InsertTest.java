package com.cxd.test;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.cxd.factory.MySqlSessionFactory;
import com.cxd.mapper.UserMapper;
import com.cxd.pojo.User;

public class InsertTest {
	@Test
	public void test() {
		SqlSession session = MySqlSessionFactory.getSqlSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		
		User user = new User(3, "aaakasha", "cxd456", "M201772456", "1220499599@qq.com");
		mapper.insertUser(user);
		session.commit();
		
		List<User> list = mapper.selectUser("aaakasha");
		
		for(User users : list) {
			System.out.println(users.getEmail());
		}
	}
}
