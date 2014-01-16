package com.oracle.backingbeans;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;

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
	
	
	//get Employee Details
		public Employee getEmployeeDetails(int employeeId)
		{
			
		 return employeeService.getEmployeeDetails(employeeId);
		}
	
	//display individual employee details	
	public String showEmployee(){
			this.selectedEmployee  = (Employee)dataTable.getRowData();
			System.out.println("#####42####"+ this.selectedEmployee.getEmployee_id()+"#########");//
			Employee employee = getEmployeeDetails(this.selectedEmployee.getEmployee_id());
			selectedEmployee = employee;
			System.out.println("####50#####" + this.selectedEmployee.getEmployee_id() + "#########");//
			return "employeeDetail"; 
		}	
	
	
	//filtering
	private List<Employee> filteredEmployee;
	
	public void setFilteredEmployee(List<Employee> filteredEmployee) {
		this.filteredEmployee = filteredEmployee;
	}

	public List<Employee> getFilteredEmployee() {  
        return filteredEmployee;  
    } 
	

	//Getters and Setters
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
