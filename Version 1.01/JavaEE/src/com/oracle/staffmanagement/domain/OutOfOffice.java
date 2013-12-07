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
@Table(name="out_of_office")
public class OutOfOffice
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int outofoffice_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date office_dateout;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date office_datein;
	
	
	public OutOfOffice()
	{
		// used by the JPA
	}

	public OutOfOffice(Date out, Date in)
	{
		this.office_dateout = out;
		this.office_datein = in;
	}
	
	//Getters and Setters
	public int getOutofoffice_id() {
		return outofoffice_id;
	}

	public void setOutofoffice_id(int outofoffice_id) {
		this.outofoffice_id = outofoffice_id;
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


}
