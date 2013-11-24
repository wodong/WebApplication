package com.oracle.staffmanagement;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.oracle.staffmanagement.dataaccess.EmployeeDataAccess;
import com.oracle.staffmanagement.domain.Employee;

@Stateless
@WebService(name="employeeSelfService")
public class EmployeeSelfServiceImplementation 
    implements EmployeeSelfServiceRemote, EmployeeSelfServiceLocal {

	@EJB
	private EmployeeDataAccess dao;

	@EJB
	private ExternalPayrollSystem payrollSystem;

	/* The following is only needed if you are manually calling setRollbackOnly().
	 * 
	 * I've left it here for use the manual approach as on the video tutorial.
	@Resource
	private SessionContext glassfish;  // this object is often called ctx
	*/

	public List<Employee> getAllEmployees() 
	{
		return dao.findAll();
	}

	/*
	 * This is the first approach to rolling back when a checked exception occurs. 
	public void registerEmployee(Employee newEmployee) throws SystemUnavailableException 
	{
		dao.insert(newEmployee);
		try
		{
		   payrollSystem.enrollEmployee(newEmployee);
		}
		catch (SystemUnavailableException e)
		{
			glassfish.setRollbackOnly();
			throw e;
		}
	}
	 */

	/*
	 * This version of register employee relies on the "SystemUnavailableExcpetion" being
	 * annotated with @ApplicationException(rollback=true)
	 */
	public void registerEmployee(Employee newEmployee) throws SystemUnavailableException 
	{
		dao.insert(newEmployee);
		payrollSystem.enrollEmployee(newEmployee);
	}

	public List<Employee> searchBySurname(String surname) {
		return dao.findBySurname(surname);
	}

	@Override
	public boolean authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}



}
