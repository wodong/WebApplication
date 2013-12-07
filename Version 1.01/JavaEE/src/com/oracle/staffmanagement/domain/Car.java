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
public class Car
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int car_id;
	
	private String vehicle_regno;
	private String make;
	private String model;
	private String colour;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_vehicle_added;
	
	private String car_or_motorbike_space;
	private int stickernumber;
	
	public Car()
	{
		// constructor used by the JPA
	}
 
	
	public Car(String carReg, String carMake, String carModel, String carColour, 
			Date carDate, String carOrMotorbike, int carSticker)
	{
		this.vehicle_regno = carReg;
		this.make = carMake;
	    this.model = carModel;
	    this.colour = carColour;
		this.date_vehicle_added = carDate;
		this.car_or_motorbike_space = carOrMotorbike; 
		this.stickernumber = carSticker;
	}
	
	
	//Getter and setters
	public String getVehicle_regno() {
		return vehicle_regno;
	}

	public void setVehicle_regno(String vehicle_regno) {
		this.vehicle_regno = vehicle_regno;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Date getDate_vehicle_added() {
		return date_vehicle_added;
	}

	public void setDate_vehicle_added(Date date_vehicle_added) {
		this.date_vehicle_added = date_vehicle_added;
	}

	public String getCar_or_motorbike_space() {
		return car_or_motorbike_space;
	}

	public void setCar_or_motorbike_space(String car_or_motorbike_space) {
		this.car_or_motorbike_space = car_or_motorbike_space;
	}

	public int getStickernumber() {
		return stickernumber;
	}

	public void setStickernumber(int stickernumber) {
		this.stickernumber = stickernumber;
	}
	
	
	

}
