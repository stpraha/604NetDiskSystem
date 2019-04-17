package com.cxd.utils;

public class RegisterUtil {
	public static boolean checkNull(String username, String password, String confirm_password, String school_id, String email) {
		if(username.equals("") || password.equals("") || confirm_password.equals("") || 
		   school_id.equals("") || email.equals("") || username == null || 
		   password == null || school_id == null|| email == null || confirm_password == null) {
			return false;
		}
		else if(!password.equals(confirm_password)) return false;
		
		else return true;
	}
}
