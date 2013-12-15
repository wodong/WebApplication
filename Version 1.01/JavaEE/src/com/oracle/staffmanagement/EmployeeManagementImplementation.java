package com.oracle.staffmanagement;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.oracle.staffmanagement.dataaccess.EmployeeDataAccess;
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

	

	public List<Employee> getAllEmployees() 
	{
		return dao.findAll();
	}
	
	public List<ParkingSpace> getAllFreeSpaces() {
		
		return dao.findAllSpaces();
	}


	public void registerEmployee(Employee newEmployee) throws SystemUnavailableException 
	{
		dao.insert(newEmployee);
		payrollSystem.enrollEmployee(newEmployee);
	}

	public List<Employee> searchBySurname(String surname) {
		return dao.findBySurname(surname);
	}	

}
