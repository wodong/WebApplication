package com.oracle.backingbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIData;
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;

import com.oracle.staffmanagement.EmployeeManagementServiceLocal;
import com.oracle.staffmanagement.domain.Employee;


@ManagedBean(name="employeeDetailBean")
public class EmployeeDetailBean {
	@EJB
	private EmployeeManagementServiceLocal employeeService;
	private Employee selectedEmployee;
	private UIData dataTable;
	private List<Employee> filteredEmployee;
	
	public String visitorName;	
    public Date startDate;
	public Date endDate;
	
	public EmployeeDetailBean() {
		selectedEmployee = new Employee();
	}
	//Get all employees
    public List<Employee> getAllEmployees()
    {        
     return employeeService.getAllEmployees();
    }
    
    //Get Employee Details
    public Employee getEmployeeDetails(int employeeId)
    {
     return employeeService.getEmployeeDetails(employeeId);
    }
    
    //Display individual employee details        
    public String showEmployee(){
                    this.selectedEmployee  = (Employee)dataTable.getRowData();
                    System.out.println("#####42####"+ this.selectedEmployee.getEmployee_id()+"#########");//
                    Employee employee = getEmployeeDetails(this.selectedEmployee.getEmployee_id());
                    selectedEmployee = employee;
                    System.out.println("####50#####" + this.selectedEmployee.getEmployee_id() + "#########");//
                    return "comEmployeeDetail"; 
            }
	
	
	// Add Visitor
	public String addVisitor(ActionEvent event){

		try {
			Object hidden = event.getComponent().getAttributes().get("submitEmployeeId");
			System.out.println( "================= OBJECT = " + this.selectedEmployee.getEmployee_id() );

			selectedEmployee = employeeService.getEmployeeDetails( this.selectedEmployee.getEmployee_id() );
			selectedEmployee.addVisitor(visitorName, startDate, endDate);
			employeeService.UpdateEmployee(selectedEmployee);
			return "comAllEmployee";
		} catch (Throwable e) 
		{	
			e.printStackTrace();
			return "comSystemDown";
		}
	}
	
	//Add New Note 
	public void addNewNote(){
		
		//To implement for Add New Note to Employee Profile.	
	}
		
	
	//Row editing
	public void onEdit(RowEditEvent event) { 
		//To implement for Employee Profile.		    
	    }  
	      
    public void onCancel(RowEditEvent event) {  
	        
	    } 
    
    //Filtering    
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
