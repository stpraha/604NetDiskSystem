package com.cxd.pojo;

public class User {
	private int userid;
	private String username;
	private String password;
	private String schoolId;
	private String email;
	private boolean admin;
	
	User() {
		
	}

	public User(int userid, String username, String password, String schoolId, String email, boolean admin) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.schoolId = schoolId;
		this.email = email;
		this.admin = admin;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
