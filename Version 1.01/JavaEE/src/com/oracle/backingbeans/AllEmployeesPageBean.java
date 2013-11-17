package com.oracle.backingbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIData;

import com.oracle.staffmanagement.EmployeeManagementServiceLocal;
import com.oracle.staffmanagement.domain.Employee;

@ManagedBean(name="allEmployeesPageBean")
public class AllEmployeesPageBean {
	int testcommit;
	@EJB
	private EmployeeManagementServiceLocal employeeService;
	private Employee selectedEmployee;
	private UIData dataTable;
	
	
	public List<Employee> getAllEmployees()
	{
		
	 return employeeService.getAllEmployees();
	}
	
	public String showEmployee(){
		
		this.selectedEmployee  = (Employee)dataTable.getRowData();
		
		return "employeeDetail";
		
	}
	
	

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

}
