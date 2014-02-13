package com.oracle.backingbeans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import com.oracle.staffmanagement.EmployeeManagementServiceLocal;
import com.oracle.staffmanagement.domain.Employee;
import com.oracle.staffmanagement.domain.OutOfOffice;
import com.oracle.staffmanagement.domain.ParkingAllocation;
import com.oracle.staffmanagement.domain.ParkingSpace;


@ManagedBean(name="wworkForToday")
public class EmployeeWorkForTodayBean {
	@EJB
	private EmployeeManagementServiceLocal employeeService;
	private Employee selectedEmployee;
	public Date endDate;
	
	
	
	//Approve and allocate parking space
	public String allocateApprove(ActionEvent event){

		try { 
			
		   selectedEmployee = employeeService.getEmployeeDetails( this.selectedEmployee.getEmployee_id() );

		   Employee employeeOnLeave = selectedEmployee.getAllocationRequests().get(0).getOutofoffice().getEmployee();
		   ParkingSpace psOfEmployeeOnLeave = employeeOnLeave.getPermParking().getParkingspace();
		   //OutOfOffice outOffice = selectedEmployee.getA
		   
		   ParkingAllocation tempAllocation = new ParkingAllocation();
		   
		   tempAllocation.setEnd_date(endDate);
		   tempAllocation.setIs_permanent(false);
		   tempAllocation.setParkingspace(psOfEmployeeOnLeave);
		   
		   selectedEmployee.addParkingAllocation(tempAllocation);
		   
		   employeeService.UpdateEmployee(selectedEmployee);
		   
		   
			 
			return "comWorkForToday";
		} catch (Throwable e) 
		{	
			e.printStackTrace();
			return "comSystemDown";
		}
	}
	
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
	
	




	public EmployeeManagementServiceLocal getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeManagementServiceLocal employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}




	public Date getEndDate() {
		return endDate;
	}




	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	

}
