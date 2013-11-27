package com.oracle.staffmanagement.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.oracle.staffmanagement.domain.Employee;

@Stateless
public class EmployeeAuthenticationImplementation
{	
	@PersistenceContext
	private EntityManager em;
	
	
	public String getPassword(String employee_no) {
		Query q = em.createQuery("select password from Employee employee where employee.employee_no = :employee_no");
		q.setParameter("employee_no", employee_no);
		return (String) q.getSingleResult();
		
	}

	/*public boolean checkCredentials(String user, String Password) {		
		Query q = em.createQuery("select employee from Employee employee");		
		List<Employee> results = q.getResultList();
		//return results;
		/*if the list is empty
		[19:05:39] Usman Habib: then return false
		[19:05:51] Usman Habib: if the list has employee against the username and password
		[19:05:59] Usman Habib: then return true */
	

}



