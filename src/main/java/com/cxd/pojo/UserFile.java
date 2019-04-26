package com.cxd.pojo;

public class UserFile {
	private int fileId;
	private String fileName;
	private int fileSize;
	private String fileTime;
	private String fileOwner;
	private boolean fileVisibility;
	private String fileLoc;
	private String fileStoreName;

	public String getFileStoreName() {
		return fileStoreName;
	}

	public void setFileStoreName(String fileStoreName) {
		this.fileStoreName = fileStoreName;
	}

	UserFile() {
		
	}
	
	public UserFile(int fileId, String fileName, int fileSize, String fileTime, String fileOwner, boolean fileVisibility, String fileLoc, String fileStoreName) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileTime = fileTime;
		this.fileOwner = fileOwner;
		this.fileVisibility = fileVisibility;
		this.fileLoc= fileLoc;
		this.fileStoreName = fileStoreName;
		
	}
	
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileTime() {
		return fileTime;
	}
	public void setFileTime(String fileTime) {
		this.fileTime = fileTime;
	}
	public String getFileOwner() {
		return fileOwner;
	}
	public void setFileOwner(String fileOwner) {
		this.fileOwner = fileOwner;
	}
	public boolean isFileVisibility() {
		return fileVisibility;
	}
	public void setFileVisibility(boolean fileVisibility) {
		this.fileVisibility = fileVisibility;
	}
	public String getFileLoc() {
		return fileLoc;
	}
	public void setFileLoc(String fileLoc) {
		this.fileLoc = fileLoc;
	}
	
}
