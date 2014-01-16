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
public class Visitor
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int visitor_id;
	
	@Temporal(TemporalType.DATE) 
	private Date allocation_start_datetime;
	@Temporal(TemporalType.DATE)
	private Date allocation_end_datetime;
	
	private String visitor_name;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="employee_employee_id", referencedColumnName="employee_id")
	private Employee employee;
	
	public Visitor()
	{
		// constructor used by the JPA
	}
		
	public Visitor(String visitorName, Date startDate, Date endDate)
	{
		this.visitor_name = visitorName;
		this.allocation_end_datetime = endDate;
		this.allocation_start_datetime = endDate;	
	}

	
	//Getters and Setters
	public Employee getEmployee() {
			return employee;
		}

	public void setEmployee(Employee employee) {
			this.employee = employee;
		}
	
	public Date getAllocation_start_datetime() {
		return allocation_start_datetime;
	}

	public void setAllocation_start_datetime(Date allocation_start_datetime) {
		this.allocation_start_datetime = allocation_start_datetime;
	}

	public Date getAllocation_end_datetime() {
		return allocation_end_datetime;
	}

	public void setAllocation_end_datetime(Date allocation_end_datetime) {
		this.allocation_end_datetime = allocation_end_datetime;
	}

	public String getVisitor_name() {
		return visitor_name;
	}

	public void setVisitor_name(String visitor_name) {
		this.visitor_name = visitor_name;
	}
 

}
