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
public class Block
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int block_id;
	
	private String block_code;
	private String block_description;
	
	
	public Block()
	{
		// constructor used by the JPA
	}
 
	
	public Block(String blockCode, String blockDesc)
	{
		this.block_code = blockCode;
		this.block_description = blockDesc;
	}
    
	
	// Getters and setters
	public String getBlock_code() {
		return block_code;
	}


	public void setBlock_code(String block_code) {
		this.block_code = block_code;
	}


	public String getBlock_description() {
		return block_description;
	}


	public void setBlock_description(String block_description) {
		this.block_description = block_description;
	}
        
	
}


