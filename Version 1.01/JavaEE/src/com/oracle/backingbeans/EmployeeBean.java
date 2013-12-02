package com.oracle.backingbeans;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="user")
public class EmployeeBean 
{
	private String name;
	private Date currentDateAndTime;

	public String getName() {
		
		String pass;
		pass = name.hashCode() + "";
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public Date getCurrentDateAndTime() {
		return currentDateAndTime;
	}

	public void setCurrentDateAndTime(Date currentDateAndTime) {
		this.currentDateAndTime = currentDateAndTime;
	}

	public String greetUser()
	{
		// 1. Do business processing
		currentDateAndTime = new java.util.Date();
		
		// 2. Forward to the next page
		return "welcome";
	}
	
	
}
