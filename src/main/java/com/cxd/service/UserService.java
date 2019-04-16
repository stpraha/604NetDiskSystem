package com.cxd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxd.dao.UserDao;


//@Service("userService")注解是告诉Spring，当Spring要创建UserServiceImpl的的实例时，
//bean的名字必须叫做"userService"，这样当Action需要使用UserServiceImpl的的实例时,
//就可以由Spring创建好的"userService"，然后注入给Action：在Action只需要声明一个名字叫“userService”的变量
//来接收由Spring注入的"userService"即可，具体代码如下：
@Service("userService")
public class UserService{
	
	@Autowired
	private UserDao userDao;

	public void showUser() {
		System.out.println("show in userService");
		this.userDao.showUser();
	}

}
