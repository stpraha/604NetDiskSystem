package com.cxd.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.cxd.factory.MySqlSessionFactory;
import com.cxd.mapper.UserFileMapper;
import com.cxd.mapper.UserMapper;
import com.cxd.pojo.UserFile;
import com.cxd.pojo.User;
import com.sun.tools.internal.xjc.model.SymbolSpace;

public class FileTest {

	private MySqlSessionFactory mySqlSessionFactory;
	
//	//@Test
//	public void selectAllTest() {
//		mySqlSessionFactory = new MySqlSessionFactory();
//		
//		SqlSession session = mySqlSessionFactory.getSqlSession();
//		
//		FileMapper mapper = session.getMapper(FileMapper.class);
//		
//		List<File> list = mapper.selectAllFile();
//		
//		for(File file : list) {
//			System.out.println(file.getFileOwner());
//		}
//	}
	
//	@Test
//	public void selectByOwnerTest() {
//		mySqlSessionFactory = new MySqlSessionFactory();
//		
//		SqlSession session = mySqlSessionFactory.getSqlSession();
//		
//		FileMapper mapper = session.getMapper(FileMapper.class);
//		
//		List<File> list = mapper.selectFileByOwner("aaakasha");
//		
//		for(File file : list) {
//			System.out.println(file.getFileName());
//		}
//	}
	
//	@Test
//	public void selectPublicFileTest() {
//		mySqlSessionFactory = new MySqlSessionFactory();
//		
//		SqlSession session = mySqlSessionFactory.getSqlSession();
//		
//		FileMapper mapper = session.getMapper(FileMapper.class);
//		
//		List<File> list = mapper.selectPublicFile();
//		
//		for(File file : list) {
//			System.out.println(file.getFileName());
//		}
//	}
	
//	@Test
//	public void changeFileVisibilityTest() {
//		mySqlSessionFactory = new MySqlSessionFactory();
//		
//		SqlSession session = mySqlSessionFactory.getSqlSession();
//		
//		FileMapper mapper = session.getMapper(FileMapper.class);
//		
//		mapper.changeFileVisibility(1, false);
//		
//		session.commit();
//	}
	
//	@Test
//	public void deleteFileTest() {
//		mySqlSessionFactory = new MySqlSessionFactory();
//		
//		SqlSession session = mySqlSessionFactory.getSqlSession();
//		
//		FileMapper mapper = session.getMapper(FileMapper.class);
//		
//		mapper.deleteFile(5);		
//		session.commit();
//	}
	
//	@Test
//	public void deleteFileByNameTest() {
//		mySqlSessionFactory = new MySqlSessionFactory();
//		
//		SqlSession session = mySqlSessionFactory.getSqlSession();
//		
//		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
//		
//		mapper.deleteFileByFileName("addFileTest");		
//		
//		session.commit();
//	}
	
//	@Test
//	public void addFileTest() {
//		mySqlSessionFactory = new MySqlSessionFactory();
//		
//		SqlSession session = mySqlSessionFactory.getSqlSession();
//		
//		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
//		
//		UserFile file = new UserFile(66, "addFileTest22", 566, "1970-01-02 00:11:22", "stpraha", false, "rqwer1324rr");
//		
//		mapper.insertFile(file);	
//		session.commit();
//	}
	
//	@Test
//	public void selectByFilenameTest() {
//		mySqlSessionFactory = new MySqlSessionFactory();
//		
//		SqlSession session = mySqlSessionFactory.getSqlSession();
//		
//		FileMapper mapper = session.getMapper(FileMapper.class);
//		
//		File file = mapper.selectFileByFilename("addFileTest");
//		
//		System.out.println(file.getFileOwner());
//	}
	
//	@Test
//	public void selectByFilenameTest() {
//		mySqlSessionFactory = new MySqlSessionFactory();
//		
//		SqlSession session = mySqlSessionFactory.getSqlSession();
//		
//		FileMapper mapper = session.getMapper(FileMapper.class);
//		
//		File file = mapper.selectFileByFilename("addFileTest");
//		
//		System.out.println(file.getFileOwner());
//	}
	
}




