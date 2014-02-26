package com.oracle.staffmanagement.dataaccess;

import java.util.List;

import com.oracle.staffmanagement.domain.AllocationRequest;
import com.oracle.staffmanagement.domain.Employee;
import com.oracle.staffmanagement.domain.OutOfOffice;
import com.oracle.staffmanagement.domain.ParkingSpace;

public interface EmployeeDataAccess {

	public abstract List<Employee> findAll();
	
	public abstract List<ParkingSpace> findAllSpaces();
	
	//public abstract List<OutOfOffice> findAllOutOffice();
	
	public List<AllocationRequest> findAllocationRequest();
	
	public abstract Employee findEmployeeDetails(int employeeId);
	public abstract Employee findByEmployeeNoo(String employee_no);

	public abstract List<Employee> findBySurname(String surname);
	
	public abstract Employee findByEmployeeNo(String employee_no);
	

	public abstract void insert(Employee newEmployee);
	
	public abstract void updateEmployee(Employee updateEmployee);
	
	public void deleteAllocationRequest(AllocationRequest allocationRequest);

}