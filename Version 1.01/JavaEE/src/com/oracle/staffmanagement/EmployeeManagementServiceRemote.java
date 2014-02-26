package com.oracle.staffmanagement;

import java.util.List;

import javax.ejb.Remote;

import com.oracle.staffmanagement.domain.AllocationRequest;
import com.oracle.staffmanagement.domain.Employee;
import com.oracle.staffmanagement.domain.ParkingSpace;

@Remote
public interface EmployeeManagementServiceRemote 
{
	public void registerEmployee(Employee newEmployee) throws SystemUnavailableException ;
	public void UpdateEmployee(Employee newUpdateEmployee) throws SystemUnavailableException;
	public void addParkingAllocation(Employee newUpdateEmployee) throws SystemUnavailableException;
	public List<Employee> getAllEmployees();
	public List<AllocationRequest> getAllocationRequests();
	public Employee getEmployeeDetails(int employeeId);
	public List<Employee> searchBySurname(String surname);
	public Employee searchByEmployeeNo(String employee_no);
	public Employee searchByEmployeeNoo(String employee_no);
	
	public List<ParkingSpace> getAllFreeSpaces();
}
