package com.oracle.backingbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="loginUser")
public class LoginBean{
	
	String username;
	String password;
	
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
	
	//provisional implementation 
	public String jumpTo() {
		
		return "allEmployees";
	}
	
	
	
}