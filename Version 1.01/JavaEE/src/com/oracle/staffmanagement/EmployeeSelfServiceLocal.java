package com.oracle.staffmanagement;

import java.util.List;

import javax.ejb.Local;

import com.oracle.staffmanagement.domain.Employee;

@Local
public interface EmployeeSelfServiceLocal 
{
	public void registerEmployee(Employee newEmployee) throws SystemUnavailableException ;
	public List<Employee> getAllEmployees();
	public List<Employee> searchBySurname(String surname);
}
