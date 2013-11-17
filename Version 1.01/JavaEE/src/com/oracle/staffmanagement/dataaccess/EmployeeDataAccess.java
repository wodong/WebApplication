package com.oracle.staffmanagement.dataaccess;

import java.util.List;

import com.oracle.staffmanagement.domain.Employee;

public interface EmployeeDataAccess {

	public abstract List<Employee> findAll();

	public abstract List<Employee> findBySurname(String surname);

	public abstract void insert(Employee newEmployee);

}