package com.oracle.backingbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIData;
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;

import com.oracle.staffmanagement.EmployeeManagementServiceLocal;
import com.oracle.staffmanagement.domain.AllocationRequest;
import com.oracle.staffmanagement.domain.Employee;
import com.oracle.staffmanagement.domain.ParkingAllocation;
import com.oracle.staffmanagement.domain.ParkingSpace;

@RequestScoped
@ManagedBean(name="workForToday")
public class WorkForTodayPageBean  {

	@EJB
	private EmployeeManagementServiceLocal employeeService;

	private Employee selectedEmployee;
	public Date endDate;
	private UIData dataTable;
	
	
	
	public WorkForTodayPageBean(){
		
		selectedEmployee = new Employee();
	}
	
	
	//get all employees
	public List<AllocationRequest> getAllAllocationRequest()
	{
		
	 return employeeService.getAllocationRequests();
	}
	
	
/*	//get Employee Details
		public Employee getEmployeeDetails(int employeeId)
		{
			
		 return employeeService.getEmployeeDetails(employeeId);
		}*/
	
/*	//display individual employee details	
	public String showEmployee(){
			this.selectedEmployee  = (Employee)dataTable.getRowData();
			System.out.println("#####42####"+ this.selectedEmployee.getEmployee_id()+"#########");//
			Employee employee = getEmployeeDetails(this.selectedEmployee.getEmployee_id());
			selectedEmployee = employee;
			System.out.println("####50#####" + this.selectedEmployee.getEmployee_id() + "#########");//
			return "comEmployeeDetail"; 
		}	
	*/
	
	public String allocateApprove(ActionEvent event){
		
		
		try { 
			
			Class clazz = dataTable.getRowData().getClass(); 
			System.out.println("###################################" + clazz );
			
			AllocationRequest ar = (AllocationRequest ) dataTable.getRowData();
			System.out.println("################allocation req " + ar.getRequest_id() );
			selectedEmployee = ar.getEmployee();
			System.out.println("################allocation req2 " + selectedEmployee.getEmployee_id() );
			
			
		   selectedEmployee = employeeService.getEmployeeDetails( this.selectedEmployee.getEmployee_id() );

		   Employee employeeOnLeave = selectedEmployee.getAllocationRequests().get(0).getOutofoffice().getEmployee();
		   ParkingSpace psOfEmployeeOnLeave = employeeOnLeave.getPermParking().getParkingspace();
		   //OutOfOffice outOffice = selectedEmployee.getA
		   
		   ParkingAllocation tempAllocation = new ParkingAllocation();
		   
		   tempAllocation.setEnd_date(endDate);
		   tempAllocation.setIs_permanent(false);
		   tempAllocation.setParkingspace(psOfEmployeeOnLeave);
		   
		   selectedEmployee.addParkingAllocation(tempAllocation);
		   
		   employeeService.UpdateEmployee(selectedEmployee); 
		   
		   
			 
			return "comWorkForToday";
		} catch (Throwable e) 
		{	
			e.printStackTrace();
			return "comSystemDown";
		}
	}
	
	// Revoke button
	public String allocateRevoke(ActionEvent event){

		try { 
			
		   System.out.println("Parking space request has been revoked");
			 
			return "comWorkForToday";
		} catch (Throwable e) 
		{	
			e.printStackTrace();
			return "comSystemDown";
		}
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
/*	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}*/

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
		    return "comAllEmployee";
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
    
    
    
    public EmployeeManagementServiceLocal getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeManagementServiceLocal employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}




	public Date getEndDate() {
		return endDate;
	}




	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


    
    
    
    
}
