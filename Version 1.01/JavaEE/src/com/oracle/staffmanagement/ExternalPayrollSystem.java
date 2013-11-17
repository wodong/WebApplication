package com.oracle.staffmanagement;

import javax.ejb.Stateless;

import com.oracle.staffmanagement.domain.Employee;

@Stateless
public class ExternalPayrollSystem 
{

	public void enrollEmployee(Employee newEmployee) throws SystemUnavailableException 
	{
//		if (Math.random() < 0.5)
//			throw new SystemUnavailableException();
//		else
		{
			// do some complex processing.
		}
	}
	
}
