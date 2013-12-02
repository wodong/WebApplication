package com.oracle.staffmanagement.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Employee implements java.io.Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int employee_id;
	
	private String employee_no;
	private String firstname;
	private String lastname;
	private String password;
	private String employment_status;
	 
	
	@Temporal(TemporalType.DATE)
	private Date application_date;
	
	@Temporal(TemporalType.DATE)
	private Date allocation_exp_date;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="employee_employee_id")
	private Set<Note> notes;
	
	public Employee() 
	{
		// required by JPA, but not used by us.
		  
	}
		
	public Employee(String employee_no, String firstname, String lastname, String password, 
			Date application_date, String employment_status, Date allocation_exp_date) 
	{
		super();
		this.notes = new HashSet<Note>();
		this.employee_no = employee_no;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.application_date = application_date;
		this.employment_status = employment_status;
		this.allocation_exp_date = allocation_exp_date;
	}

	public String toString()
	{
		return "Employee " + this.employee_no + " " + this.firstname;
	}
	
	
	public void addNote(String newNoteText)
	{
		Note newNote = new Note(newNoteText);
		this.notes.add(newNote);
	}


	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	public Set<Note> getAllNotes() 
	{
		return this.notes;
	}
	
	 
	
	//Getters and Setters

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

	
}
