package com.oracle.staffmanagement.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
@Table(name="parking_space")
public class ParkingSpace implements java.io.Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pspace_id;
	private int space_no;
	private int block_block_id;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="block_block_id")
	private Block block;
	
	/*@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="parking_space_pspace_id")
	private List<Employee> employees;*/
	
	/*//==============================================
		@OneToMany(mappedBy = "Employee")
		 private List<EmployeeParkingSpace> employeeParkingSpace;
		
	//==============================================*/
	
	
	
	public ParkingSpace()
	{
		// constructor used by the JPA
	}
 
	
	public int getPspace_id() {
		return pspace_id;
	}


	public void setPspace_id(int pspace_id) {
		this.pspace_id = pspace_id;
	}


	public int getBlock_block_id() {
		return block_block_id;
	}


	public void setBlock_block_id(int block_block_id) {
		this.block_block_id = block_block_id;
	}


	public Block getBlock() {
		return block;
	}


	public void setBlock(Block block) {
		this.block = block;
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


