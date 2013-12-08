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
    //Employee variables 
	private String employee_no;
	private String firstname;
	private String lastname;
	private String password = passwordGenerator();
	private Date application_date ;
	private Date allocation_exp_date;
	private String employeeStatus;
	//Note variables
	private String notes;
	//Out of Office variables
	private Date office_dateout ;
	private Date office_datein;
	//Contact variables
	private String company;
	private String email;
	private int phonenumber;
	private String linemanager;
	private int postcode;
	private String lineofbusiness;
	
	//Handle Employment status selector
    private Map<String, String> status = new HashMap<String, String>(); 
	
	//Constructor
	public EnterEmployeePageBackingBean() {
		
        status.put("Yes", "Yes");  
        status.put("No", "No");  
       
	}
	
	@EJB
	private EmployeeManagementServiceLocal employeeService;
	
	//Create Employee object
	public String createEmployee() {	
		
		String message = "Hello Dude\n=================================";
		
		System.out.println(message);
		
	    Employee newEmployee = new Employee(employee_no, firstname, lastname, password, 
				application_date, employeeStatus, allocation_exp_date);
	    newEmployee.addNote(notes);
	    newEmployee.addOutOfOffice(office_dateout, office_datein);
	    newEmployee.addContact(company, email, phonenumber, linemanager, postcode, lineofbusiness);
	    
	    try 
	    {
			employeeService.registerEmployee(newEmployee);
		    return "thankyou";
	    } catch (Throwable e) {	
	    
	    	e.printStackTrace();
	    	System.out.println(message);
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
	
	public Date getOffice_dateout() {
		return office_dateout;
	}


	public void setOffice_dateout(Date office_dateout) {
		this.office_dateout = office_dateout;
	}


	public Date getOffice_datein() {
		return office_datein;
	}


	public void setOffice_datein(Date office_datein) {
		this.office_datein = office_datein;
	}
	
	
	//Getter and setters CONTACT
	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getLinemanager() {
		return linemanager;
	}


	public void setLinemanager(String linemanager) {
		this.linemanager = linemanager;
	}


	public int getPostcode() {
		return postcode;
	}


	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}


	public String getLineofbusiness() {
		return lineofbusiness;
	}


	public void setLineofbusiness(String lineofbusiness) {
		this.lineofbusiness = lineofbusiness;
	}

}
