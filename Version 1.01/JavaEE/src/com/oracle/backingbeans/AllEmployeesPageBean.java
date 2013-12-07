package com.oracle.backingbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIData;

import org.primefaces.event.RowEditEvent;

import com.oracle.staffmanagement.EmployeeManagementServiceLocal;
import com.oracle.staffmanagement.domain.Employee;

@ManagedBean(name="allEmployeesPageBean")
public class AllEmployeesPageBean {
	@EJB
	private EmployeeManagementServiceLocal employeeService;
	private Employee selectedEmployee;
	private UIData dataTable;
	
	//get all employees
	public List<Employee> getAllEmployees()
	{
		
	 return employeeService.getAllEmployees();
	}
	
	//display individual employee details
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

	
	//row editing
	public void onEdit(RowEditEvent event) {  
        
    }  
      
    public void onCancel(RowEditEvent event) {  
        
    }  
}
