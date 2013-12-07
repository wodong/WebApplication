package com.oracle.staffmanagement.domain;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;


@Entity
public class Note
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int note_id;
	private String txt_note;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	
	public Note()
	{
		// for JPA
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
