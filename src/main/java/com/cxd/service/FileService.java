package com.cxd.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cxd.factory.MySqlSessionFactory;
import com.cxd.mapper.UserFileMapper;
import com.cxd.pojo.UserFile;

//@Service("userService")注解是告诉Spring，当Spring要创建UserServiceImpl的的实例时，
//bean的名字必须叫做"userService"，这样当Action需要使用UserServiceImpl的的实例时,
//就可以由Spring创建好的"userService"，然后注入给Action：在Action只需要声明一个名字叫“userService”的变量
//来接收由Spring注入的"userService"即可，具体代码如下：
@Service("fileService")
public class FileService{
	
	@Autowired
	private MySqlSessionFactory mySqlSessionFactory;
	
	public List<UserFile> selectAllFile() {
		mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		List<UserFile> fileList = mapper.selectAllFile();
		
		return fileList;
	}
	
	public List<UserFile> selectFileByOwner(String owner) {
		mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		List<UserFile> fileList = mapper.selectFileByOwner(owner);
		
		return fileList;
	}
	
	public List<UserFile> selectPublicFile() {
		mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		List<UserFile> fileList = mapper.selectPublicFile();

		return fileList;
	}
	
	public void changeFileVisibilityFalse(int fileId) {
		mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		mapper.changeFileVisibility(fileId, false);
		
		session.commit();
	}
	
	public void changeFileVisibilityTrue(int fileId) {
		mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		mapper.changeFileVisibility(fileId, true);
		
		session.commit();
	}
	
	public void deleteFileByFileId(int fileId) {
		mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		mapper.deleteFileByFileId(fileId);
		
		session.commit();
	}
	
	public void deleteFileByFileName(String filename) {
		mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		mapper.deleteFileByFileName(filename);
		
		session.commit();
	}
	
	public void addFile(UserFile file) {
		mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		if(mapper.selectFileByFilename(file.getFileName()) != null) 
			return;
		else {
			mapper.insertFile(file);
			session.commit();
		}
	}
	
	public UserFile selectByFilename(String filename) {
		mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		UserFile file = mapper.selectFileByFilename(filename);
		
		return file;
	}
	
	public UserFile selectByFileId(int fileId) {
		mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		UserFile file = mapper.selectFileByFileId(fileId);
		
		return file;
	}
	
	public void coverFileByFilename(UserFile file) {
		mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		mapper.deleteFileByFileName(file.getFileName());
		
		mapper.insertFile(file);
		
		session.commit();
	}
}
