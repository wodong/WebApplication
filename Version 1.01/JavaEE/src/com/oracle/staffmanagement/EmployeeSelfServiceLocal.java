package com.oracle.staffmanagement;

import java.util.List;

import javax.ejb.Local;

import com.oracle.staffmanagement.domain.Employee;

@Local
public interface EmployeeSelfServiceLocal 
{
	public String findPassword(String employee_no);
}
