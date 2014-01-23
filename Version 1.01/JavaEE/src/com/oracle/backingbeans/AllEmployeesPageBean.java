package com.oracle.backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIData;

import org.primefaces.event.RowEditEvent;

import com.oracle.staffmanagement.EmployeeManagementServiceLocal;
import com.oracle.staffmanagement.domain.Employee;

@RequestScoped
@ManagedBean(name="allEmployeesPageBean")
public class AllEmployeesPageBean implements Serializable {
	/**
	 * 
	 */
	
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
	public String onEdit(RowEditEvent event) {
		Employee oldValue = (Employee) event.getObject();  
	    Employee newValue = (Employee) event.getObject();
	    
	    System.out.println("#################################" + newValue);
	    
	    try 
	    {
	    	employeeService.UpdateEmployee(newValue);
		    return "allEmployee";
	    } catch (Throwable e) {	
	    	
	    	e.printStackTrace();
			return "systemDown";
		}
	    
	  /*  if(newValue != null && !newValue.equals(oldValue)) {  
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }*/
		
        
    }  
      
    public void onCancel(RowEditEvent event) {  
    	Employee e=(Employee) event.getObject();
    	e.setEmployee_no("1245");
        
    }  
}
