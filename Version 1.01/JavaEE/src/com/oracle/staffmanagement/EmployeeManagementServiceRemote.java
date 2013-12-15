package com.oracle.staffmanagement;

import java.util.List;

import javax.ejb.Remote;

import com.oracle.staffmanagement.domain.Employee;
import com.oracle.staffmanagement.domain.ParkingSpace;

@Remote
public interface EmployeeManagementServiceRemote 
{
	public void registerEmployee(Employee newEmployee) throws SystemUnavailableException ;
	public List<Employee> getAllEmployees();
	public List<ParkingSpace> getAllFreeSpaces();
	public List<Employee> searchBySurname(String surname);
}
