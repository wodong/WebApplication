package com.oracle.restful;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.oracle.staffmanagement.EmployeeManagementServiceLocal;
import com.oracle.staffmanagement.domain.Employee;
import com.oracle.staffmanagement.domain.ParkingSpace;



@Path("/spaces")
@Stateless
public class ParkingSpacesResource {
	
	
	@EJB
	private EmployeeManagementServiceLocal employeeManagement;
	
	@GET
	@Produces("application/json")
	public List<ParkingSpace> getAllFreeSpaces(){
		
		return employeeManagement.getAllFreeSpaces();
	}
	
	
}
