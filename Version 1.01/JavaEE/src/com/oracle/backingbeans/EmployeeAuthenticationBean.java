package com.oracle.backingbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import com.oracle.staffmanagement.EmployeeSelfServiceLocal;


@ManagedBean(name="loginUser")
public class EmployeeAuthenticationBean{	
	@EJB
	private EmployeeSelfServiceLocal employeePassService;
	
	private String username;
	private String password;

    // setters and getters		
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
	
	
	//return password from db
	public String findPassword(String employee_no)
	{	
		return employeePassService.findPassword(employee_no);	
	}
	
	//check password against the one from db
    public String userLogin(){
		
		if(password.equals(findPassword(username))){
			return "allEmployees";		
		}
		else 
		{	
			//just for testing 
			return "systemDown";
		}
		
	}

	
}