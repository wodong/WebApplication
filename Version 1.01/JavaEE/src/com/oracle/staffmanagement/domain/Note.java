package com.oracle.staffmanagement.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Note
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int note_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String txt_note;
	/*private int employee_employee_id;*/
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="employee_employee_id", referencedColumnName="employee_id")
	private Employee employee;
	
	
	public Note()
	{
		// for JPA
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	/*public int getEmployee_employee_id() {
		return employee_employee_id;
	}

	public void setEmployee_employee_id(int employee_employee_id) {
		this.employee_employee_id = employee_employee_id;
	}*/
    
	public int getNote_id() {
		return note_id;
	}

	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}

	public String getTxt_note() {
		return txt_note;
	}

	public void setTxt_note(String txt_note) {
		this.txt_note = txt_note;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Note(String text)
	{
		this.date = new java.util.Date();
		this.txt_note = text;
	}

	public String toString()
	{
		return "Note raised at " + this.date + " with contents " + this.txt_note;
	}
}
