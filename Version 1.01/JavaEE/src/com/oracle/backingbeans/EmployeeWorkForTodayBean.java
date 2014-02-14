package com.oracle.backingbeans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIData;
import javax.faces.event.ActionEvent;

import com.oracle.staffmanagement.EmployeeManagementServiceLocal;
import com.oracle.staffmanagement.domain.Employee;
import com.oracle.staffmanagement.domain.OutOfOffice;
import com.oracle.staffmanagement.domain.ParkingAllocation;
import com.oracle.staffmanagement.domain.ParkingSpace;


@ManagedBean(name="wworkForToday")
public class EmployeeWorkForTodayBean {
	

	//Approve and allocate parking space
	
	
	// Revoke the parking allocation request
	public String allocateRevoke(ActionEvent event){

		try { 
			
		   System.out.println("Parking space request has been revoked");
			 
			return "comWorkForToday";
		} catch (Throwable e) 
		{	
			e.printStackTrace();
			return "comSystemDown";
		}
	}
	
	

	
	
	
	

}
