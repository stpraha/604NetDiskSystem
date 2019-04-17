package com.cxd.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cxd.factory.MySqlSessionFactory;
import com.cxd.mapper.UserMapper;
import com.cxd.pojo.User;

//@Service("userService")注解是告诉Spring，当Spring要创建UserServiceImpl的的实例时，
//bean的名字必须叫做"userService"，这样当Action需要使用UserServiceImpl的的实例时,
//就可以由Spring创建好的"userService"，然后注入给Action：在Action只需要声明一个名字叫“userService”的变量
//来接收由Spring注入的"userService"即可，具体代码如下：
@Service("userService")
public class UserService{
	
	@Autowired
	private MySqlSessionFactory mySqlSessionFactory;
	
	public User verifyUser(String username, String password) {
		User user = null;
		
		if(username == null || username.equals("") || password == null|| password.equals("")) return user; 
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		user = (User)userMapper.selectUser(username);
		
		if(user.getPassword().equals(password)) {
			return user;
		}
		else {
			return null;
		}
	}
	
	public boolean checkUser(String username) {
		if(username == null || username.equals("")) return false; 
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = (User)userMapper.selectUser(username);
		
		if(user != null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void addUser(User user) {
		if(user == null) return;
		SqlSession session = mySqlSessionFactory.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		userMapper.insertUser(user);
		session.commit();
	}
}
