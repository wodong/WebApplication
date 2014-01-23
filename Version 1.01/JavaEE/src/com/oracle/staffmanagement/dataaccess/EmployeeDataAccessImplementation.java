package com.oracle.staffmanagement.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.oracle.staffmanagement.domain.Employee;
import com.oracle.staffmanagement.domain.ParkingSpace;

@Stateless
public class EmployeeDataAccessImplementation implements EmployeeDataAccess
{	
	@PersistenceContext
	private EntityManager em;

	// Web service, find Parking SPaces
	public List<ParkingSpace> findAllSpaces() {		
		//Query q = em.createQuery("SELECT parking_space FROM ParkingSpace parking_space, Block block WHERE parking_space.block_block_id = block.block_id");	
		Query q = em.createQuery("select parking_space from ParkingSpace parking_space");
		List<ParkingSpace> spaces = q.getResultList();	
		return spaces;	
	}

	//Find all Employees
		public List<Employee> findAll() {		
			Query q = em.createQuery("select employee from Employee employee");		
			List<Employee> results = q.getResultList();
			return results;
		}
	
	//Find Employee and Note
		public Employee findEmployeeDetails(int employeeId) {
			Query q = em.createQuery("select employee from Employee employee where employee.employee_id = :employeeId");
			q.setParameter("employeeId", employeeId);
			Employee employeeDet = (Employee) q.getSingleResult();
			
			return employeeDet;
		}	
		
		
		
	public List<Employee> findBySurname(String surname) {
		Query q = em.createQuery("select employee from Employee employee where employee.surname = :surname");
		q.setParameter("surname", surname);
		return q.getResultList();
	}

	public void insert(Employee newEmployee) {
		em.persist(newEmployee);	
	}

	public void updateEmployee(Employee updateNewEmployee){
		em.merge(updateNewEmployee);	

	}
	
	
}
