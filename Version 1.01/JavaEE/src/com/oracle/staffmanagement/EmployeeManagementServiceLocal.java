package com.oracle.staffmanagement;

import java.util.List;

import javax.ejb.Local;

import com.oracle.staffmanagement.domain.AllocationRequest;
import com.oracle.staffmanagement.domain.Employee;
import com.oracle.staffmanagement.domain.ParkingSpace;

@Local
public interface EmployeeManagementServiceLocal 
{
	public void registerEmployee(Employee newEmployee) throws SystemUnavailableException ;
	public void UpdateEmployee(Employee newUpdateEmployee) throws SystemUnavailableException;
	public List<Employee> getAllEmployees();
	public List<AllocationRequest> getAllocationRequests();
	public Employee getEmployeeDetails(int employeId);
	public List<ParkingSpace> getAllFreeSpaces();
	public List<Employee> searchBySurname(String surname);
	
	
	
}
