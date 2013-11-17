package com.oracle.staffmanagement.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.oracle.staffmanagement.domain.Employee;

@Stateless
public class EmployeeDataAccessImplementation implements EmployeeDataAccess
{	
	@PersistenceContext
	private EntityManager em;

	public List<Employee> findAll() {		
		Query q = em.createQuery("select employee from Employee employee");		
		List<Employee> results = q.getResultList();
		return results;
	}

	public List<Employee> findBySurname(String surname) {
		Query q = em.createQuery("select employee from Employee employee where employee.surname = :surname");
		q.setParameter("surname", surname);
		return q.getResultList();
	}

	public void insert(Employee newEmployee) {
		em.persist(newEmployee);	
	}

}
