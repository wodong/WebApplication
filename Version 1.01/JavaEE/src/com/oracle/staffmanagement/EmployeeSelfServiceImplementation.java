package com.oracle.staffmanagement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.oracle.staffmanagement.dataaccess.EmployeeAuthenticationImplementation;
import com.oracle.staffmanagement.dataaccess.EmployeeDataAccess;

@Stateless
@WebService(name="employeeSelfService")
public class EmployeeSelfServiceImplementation 
    implements EmployeeSelfServiceRemote, EmployeeSelfServiceLocal {

	@EJB
	private EmployeeAuthenticationImplementation dao;


	public String findPassword(String employee_no) 
	{
		return dao.getPassword(employee_no);
	}
	
	
	
}
