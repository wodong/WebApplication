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
@Table(name="parking_space")
public class ParkingSpace
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pspace_id;
	
	private int space_no;
	
	
	public ParkingSpace()
	{
		// constructor used by the JPA
	}
 
	
	public ParkingSpace(int spaceNo)
	{
		this.space_no = spaceNo;
	}
    
	// Getters and setters
	public int getSpace_no() {
		return space_no;
	}


	public void setSpace_no(int space_no) {
		this.space_no = space_no;
	}

    
	
}


