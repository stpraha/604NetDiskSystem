package com.cxd.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.cxd.pojo.UserFile;

@Repository
public interface UserFileMapper {
	public List<UserFile> selectFileByOwner(String owner);
	
	public List<UserFile> selectAllFile();
	
	public List<UserFile> selectPublicFile();
	
	public void insertFile(UserFile file);
	
	public void deleteFileByFileId(int fileId);
	
	public void deleteFileByFileName(String filename);
	
	public void changeFileVisibility(int fileId, boolean visibilityState);
	
	public UserFile selectFileByFilename(String filename);
	
	public UserFile selectFileByFileId(int fileid);
	
	public UserFile selectFileByFileStoreName(String fileStoreName);
}
