package com.oracle.backingbeans;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.oracle.staffmanagement.EmployeeManagementServiceLocal;
import com.oracle.staffmanagement.SystemUnavailableException;
import com.oracle.staffmanagement.domain.Employee;


@ManagedBean(name="enterEmployee")
public class EnterEmployeePageBackingBean {

    
	
    private String firstName;
	private String surname;
	private String jobRole;
	private int salary;
	private String notes;
	
	@EJB
	private EmployeeManagementServiceLocal employeeService;
	
	public String createEmployee(){
		
	    Employee newEmployee = new Employee(firstName, surname, jobRole, salary);
	    newEmployee.addNote(notes);
	    
	    try 
	    {
			employeeService.registerEmployee(newEmployee);
		    return "all-employees";
	    } catch (SystemUnavailableException e) 		    
		    {
			return "systemDown";
		    }	    
		}
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}
	

}
