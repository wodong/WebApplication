package com.oracle.staffmanagement.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.oracle.staffmanagement.domain.AllocationRequest;
import com.oracle.staffmanagement.domain.Employee;
import com.oracle.staffmanagement.domain.OutOfOffice;
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
	
	/*public List<OutOfOffice> findAllOutOffice(){		
		Query q = em.createQuery("select o from OutOfOffice o, AllocationRequest WHERE +"
				+ "ar.out_of_office_outofoffice_id = o.outofoffice_id");
		List<OutOfOffice> allOutOffice = q.getResultList();	
		return allOutOffice;			
	}*/
	
	// Find all Allocation Requests
	public List<AllocationRequest> findAllocationRequest(){		
	Query q = em.createQuery("select allocation from AllocationRequest allocation");
	List<AllocationRequest> allAllocationReq = q.getResultList();	
	return allAllocationReq;			
}

	//Find all Employees
		public List<Employee> findAll() {		
			Query q = em.createQuery("select employee from Employee employee");		
			List<Employee> results = q.getResultList();
			return results;
		}
		
	
	//Find Employee and Note
		public Employee findEmployeeDetails(int employeeId) {
			/*
			Query q = em.createQuery("select employee from Employee employee where employee.employee_id = :employeeId");
			q.setParameter("employeeId", employeeId);
			Employee employeeDet = (Employee) q.getSingleResult();
			*/
			System.out.println("-------------------------- S T A R T --------------------------" );
			
			Employee employeeDet = em.find(Employee.class, employeeId);
			
			System.out.println("----------------------------- E N D ----------------------------" );
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
	
	
	public void deleteAllocationRequest(AllocationRequest allocationRequest) {
		AllocationRequest ar = em.find(AllocationRequest.class, allocationRequest.getRequest_id());
		em.remove(ar);
	}
	
}
