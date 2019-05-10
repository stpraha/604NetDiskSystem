package com.cxd.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxd.controller.FileController;
import com.cxd.factory.MySqlSessionFactory;
import com.cxd.mapper.UserFileMapper;
import com.cxd.pojo.UserFile;
import com.cxd.utils.FileUtil;

//@Service("userService")娉ㄨВ鏄憡璇塖pring锛屽綋Spring瑕佸垱寤篣serServiceImpl鐨勭殑瀹炰緥鏃讹紝
//bean鐨勫悕瀛楀繀椤诲彨鍋�"userService"锛岃繖鏍峰綋Action闇�瑕佷娇鐢║serServiceImpl鐨勭殑瀹炰緥鏃�,
//灏卞彲浠ョ敱Spring鍒涘缓濂界殑"userService"锛岀劧鍚庢敞鍏ョ粰Action锛氬湪Action鍙渶瑕佸０鏄庝竴涓悕瀛楀彨鈥渦serService鈥濈殑鍙橀噺
//鏉ユ帴鏀剁敱Spring娉ㄥ叆鐨�"userService"鍗冲彲锛屽叿浣撲唬鐮佸涓嬶細
@Service("fileService")
public class FileService{
	
	private static final Logger logger = LogManager.getLogger(FileService.class);
	
	@Autowired
	private MySqlSessionFactory mySqlSessionFactory;
	
	public List<UserFile> selectAllFile() {
		//mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		List<UserFile> fileList = mapper.selectAllFile();
		
		return fileList;
	}
	
	public List<UserFile> selectFileByOwner(String owner) {
		//mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		List<UserFile> fileList = mapper.selectFileByOwner(owner);
		
		return fileList;
	}
	
	public List<UserFile> selectPublicFile() {
		//mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		List<UserFile> fileList = mapper.selectPublicFile();

		return fileList;
	}
	
	public void changeFileVisibilityFalse(int fileId) {
		//mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		mapper.changeFileVisibility(fileId, false);
		
		session.commit();
	}
	
	public void changeFileVisibilityTrue(int fileId) {
		//mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		mapper.changeFileVisibility(fileId, true);
		
		session.commit();
	}
	
	public void deleteFileByFileId(int fileId) {
		//mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		UserFile file = this.selectByFileId(fileId);
		
		String filePath = file.getFileLoc();
		
		mapper.deleteFileByFileId(fileId);
		
		session.commit();
		
		deleteFilePath(filePath);
	}
	
	public void deleteFileByFileName(String filename) {
		//mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		UserFile file = this.selectByFilename(filename);
		
		String filePath = file.getFileLoc();
		
		mapper.deleteFileByFileName(filename);
		
		session.commit();
		
		deleteFilePath(filePath);
	}
	
	private void deleteFilePath(String filePath) {
		try {
			FileUtil.deleteByPath(filePath);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addFile(UserFile file) {
		//mySqlSessionFactory = new MySqlSessionFactory();
		
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
		//mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		UserFile file = mapper.selectFileByFilename(filename);
		
		return file;
	}
	
	public UserFile selectByFileStoreame(String fileStoreName) {
		//mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		UserFile file = mapper.selectFileByFileStoreName(fileStoreName);
		
		return file;
	}
	
	public UserFile selectByFileId(int fileId) {
		
		System.out.println("hrer");
		//mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		
		
		UserFile file = mapper.selectFileByFileId(fileId);
		
		
		
		return file;
	}
	
	public void coverFileByFilename(UserFile file) {
		//mySqlSessionFactory = new MySqlSessionFactory();
		
		SqlSession session = mySqlSessionFactory.getSqlSession();
		
		UserFileMapper mapper = session.getMapper(UserFileMapper.class);
		
		mapper.deleteFileByFileName(file.getFileName());
		
		mapper.insertFile(file);
		
		session.commit();
	}
}
