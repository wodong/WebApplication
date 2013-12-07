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
public class Visitor
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int visitor_id;
	
	
	
	public Visitor()
	{
		// constructor used by the JPA
	}
 
	
	public Visitor(String carReg, String carMake, String carModel, String carColour, 
			Date carDate, String carOrMotorbike, int carSticker)
	{
	 
	}
	


}
