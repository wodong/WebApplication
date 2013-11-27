package com.oracle.staffmanagement;

import java.util.List;

import javax.ejb.Remote;

import com.oracle.staffmanagement.domain.Employee;

@Remote
public interface EmployeeSelfServiceRemote 
{
	public String findPassword(String employee_no);
}
