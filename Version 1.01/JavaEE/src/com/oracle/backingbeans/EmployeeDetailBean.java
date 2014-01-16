package com.oracle.backingbeans;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import com.oracle.staffmanagement.domain.Employee;



@ManagedBean(name="employeeDetail")
public class EmployeeDetailBean {
	
	String visitorName;	
	Date startDate;
	Date endDate;
	
	
	public String addVisitor(){
		
		
		
		try 
	    {
			Employee.addVisitor(visitorName, startDate, endDate);
			return "allEmployee";
	    } catch (Throwable e) {	
	    
	    	e.printStackTrace();
			return "systemDown";
		}
	}
	
	
	//Getters and Setters
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
