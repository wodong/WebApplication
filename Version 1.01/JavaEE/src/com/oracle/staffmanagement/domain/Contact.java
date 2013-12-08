package com.oracle.staffmanagement.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Contact
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int contact_id;
	
	private String company;
	private String email;
	private int phonenumber;
	private String linemanager;
	private int postcode;
	private String lineofbusiness;
	
	
	public Contact()
	{
		// constructor used by the JPA
	}
 
	
	public Contact(String conCompany, String conEmail, int conPhoneNumber, 
			String conLineManager, int conPostCode, String conLineOfBusiness)
	{
		this.company = conCompany;
		this.email  = conEmail;
	    this.phonenumber = conPhoneNumber; 
	    this.linemanager = conLineManager;
		this.postcode = conPostCode;
		this.lineofbusiness = conLineOfBusiness;
	}

    // Getters and setters
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
