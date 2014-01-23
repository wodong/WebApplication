package com.oracle.backingbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIData;

import org.primefaces.event.RowEditEvent;

import com.oracle.staffmanagement.EmployeeManagementServiceLocal;
import com.oracle.staffmanagement.domain.Employee;

@ManagedBean(name="employeeDetailBean")
public class EmployeeDetailBean {
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
	
	//row editing
		public void onEdit(RowEditEvent event) { 
			
	        
	    }  
	      
	    public void onCancel(RowEditEvent event) {  
	        
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

	
	 

    
    String visitorName;	
	Date startDate;
	Date endDate;
		

	public String addVisitor(){
			
		try 
	    {
			selectedEmployee.addVisitor(visitorName, startDate, endDate);
			return "allEmployee";
	    } catch (Throwable e) {	
	    
	    	e.printStackTrace();
			return "systemDown";
		}
	}
	
	
	//Getters and Setters
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
     
    
}
