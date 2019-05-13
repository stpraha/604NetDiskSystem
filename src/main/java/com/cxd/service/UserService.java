package com.cxd.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cxd.factory.MySqlSessionFactory;
import com.cxd.mapper.UserMapper;
import com.cxd.pojo.User;

//@Service("userService")娉ㄨВ鏄憡璇塖pring锛屽綋Spring瑕佸垱寤篣serServiceImpl鐨勭殑瀹炰緥鏃讹紝
//bean鐨勫悕瀛楀繀椤诲彨鍋�"userService"锛岃繖鏍峰綋Action闇�瑕佷娇鐢║serServiceImpl鐨勭殑瀹炰緥鏃�,
//灏卞彲浠ョ敱Spring鍒涘缓濂界殑"userService"锛岀劧鍚庢敞鍏ョ粰Action锛氬湪Action鍙渶瑕佸０鏄庝竴涓悕瀛楀彨鈥渦serService鈥濈殑鍙橀噺
//鏉ユ帴鏀剁敱Spring娉ㄥ叆鐨�"userService"鍗冲彲锛屽叿浣撲唬鐮佸涓嬶細
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
		
		if(user == null) return null;
		
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
	
	public List<User> selectAllUsers() {
		SqlSession session = mySqlSessionFactory.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		return userMapper.selectAllUser();
		
	}
}
