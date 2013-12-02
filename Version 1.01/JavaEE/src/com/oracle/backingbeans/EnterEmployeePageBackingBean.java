package com.oracle.backingbeans;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.security.SecureRandom;
import java.util.Random;
 


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.oracle.staffmanagement.EmployeeManagementServiceLocal;
import com.oracle.staffmanagement.SystemUnavailableException;
import com.oracle.staffmanagement.domain.Employee;



@ManagedBean(name="enterEmployee")
public class EnterEmployeePageBackingBean {

	private String employee_no;
	private String firstname;
	private String lastname;
	private String password = passwordGenerator();
	private Date application_date ;
	private String employment_status;
	private Date allocation_exp_date;
	private String notes;
	private String employeeStatus; 

	//Handle Employment status selector
    private Map<String,String> status = new HashMap<String, String>(); 
	
	//Constructor
	public EnterEmployeePageBackingBean() {
		
        status.put("Yes", "Yes");  
        status.put("No", "No");  
       
	}
	
	@EJB
	private EmployeeManagementServiceLocal employeeService;
	
	//Create Employee object
	public String createEmployee(){	
	    Employee newEmployee = new Employee(employee_no, firstname, lastname, password, 
				application_date, employment_status, allocation_exp_date);
	    newEmployee.addNote(notes);
	    
	    try 
	    {
			employeeService.registerEmployee(newEmployee);
		    return "thankyou";
	    } catch (SystemUnavailableException e) 		    
		    {
			return "systemDown";
		    }	    
		}
	
	
	//Generate password
	private static final Random RANDOM = new SecureRandom();
	public static final int PASSWORD_LENGTH = 8;

	public static String passwordGenerator() {
		// Pick from some letters that won't be easily mistaken for each other
		String randonChar = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";

		String passGen = "";
		for (int i=0; i<PASSWORD_LENGTH; i++)
		{
			int index = (int)(RANDOM.nextDouble()*randonChar.length());
			passGen += randonChar.substring(index, index+1);
		}
		return passGen;
	}
	
	
    //Getters and setters
	
	public String getEmployeeStatus() {
		return employeeStatus;
	}


	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
    
    
	public String getEmployee_no() {
		return employee_no;
	}


	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getApplication_date() {
		return application_date;
	}


	public void setApplication_date(Date application_date) {
		this.application_date = application_date;
	}


	public String getEmployment_status() {
		return employment_status;
	}


	public void setEmployment_status(String employment_status) {
		this.employment_status = employment_status;
	}


	public Date getAllocation_exp_date() {
		return allocation_exp_date;
	}


	public void setAllocation_exp_date(Date allocation_exp_date) {
		this.allocation_exp_date = allocation_exp_date;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}
	
    public Map<String, String> getStatus() {  
	        return status;  
	}  
	  
	public void setStatus(Map<String, String> status) {  
	        this.status = status;  
	} 
	

}
