package com.oracle.staffmanagement;

import java.util.List;

import javax.ejb.Remote;

import com.oracle.staffmanagement.domain.Employee;

@Remote
public interface EmployeeSelfServiceRemote 
{
	public void registerEmployee(Employee newEmployee) throws SystemUnavailableException ;
	public List<Employee> getAllEmployees();
	public List<Employee> searchBySurname(String surname);
}
