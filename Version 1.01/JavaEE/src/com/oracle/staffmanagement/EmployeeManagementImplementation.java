package com.oracle.staffmanagement;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.oracle.staffmanagement.dataaccess.EmployeeDataAccess;
import com.oracle.staffmanagement.domain.AllocationRequest;
import com.oracle.staffmanagement.domain.Employee;
import com.oracle.staffmanagement.domain.ParkingSpace;

@Stateless
@WebService(name="employeeManagementService")
public class EmployeeManagementImplementation 
    implements EmployeeManagementServiceRemote, EmployeeManagementServiceLocal {

	@EJB
	private EmployeeDataAccess dao;

	@EJB
	private ExternalPayrollSystem payrollSystem;

	
    // Get All employee DAO
	public List<Employee> getAllEmployees() 
	{
		return dao.findAll();
	}
	
	public List<AllocationRequest> getAllocationRequests(){
		
		return dao.findAllocationRequest();
	}
	
	//Get employeeDetails DAO
	public Employee getEmployeeDetails(int employeeId)
	{
		return dao.findEmployeeDetails(employeeId);
	}
	
	//Get All Parking Spaces Webservice DAO
	public List<ParkingSpace> getAllFreeSpaces() {
		
		return dao.findAllSpaces();
	}

    // Insert new Employee into Database DAO
	public void registerEmployee(Employee newEmployee) throws SystemUnavailableException 
	{
		dao.insert(newEmployee);
		payrollSystem.enrollEmployee(newEmployee);
	}
		
	// Update Employee when new Visitor or additional Note is added to the employee profile 
	public void UpdateEmployee(Employee newUpdateEmployee) throws SystemUnavailableException 
	{
		dao.updateEmployee(newUpdateEmployee);
		
	}
	
	//Update Employee with parking space allocation
	public void addParkingAllocation(Employee newUpdateEmployee) throws SystemUnavailableException 
	{
		dao.updateEmployee(newUpdateEmployee);
		
	}
	
	
	
	public List<Employee> searchBySurname(String surname) {
		return dao.findBySurname(surname);
	}	
	
	public void deleteAllocationRequest(AllocationRequest allocationRequest) {
		dao.deleteAllocationRequest(allocationRequest);
	}

}
