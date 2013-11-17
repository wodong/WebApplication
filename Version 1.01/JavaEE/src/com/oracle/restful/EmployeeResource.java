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



@Path("/employees")
@Stateless
public class EmployeeResource {
	
	
	@EJB
	private EmployeeManagementServiceLocal employeeManagement;
	
	@GET
	@Produces("application/json")
	public List<Employee> getAllEmployees(){
		
		return employeeManagement.getAllEmployees();
	}
	
	@GET
	@Produces("application/json")
	@Path("{id}") //matches the URL of   /employees/{id}
	public Employee findEmployeeById(@PathParam("id") String id){
		
		return new Employee("Keith", "Brown", "Official", 27000);
	}

}
