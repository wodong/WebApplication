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
	
	
	//get all employees which requested a Parking allocation
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
	
	
	// Approve parking allocation
	public String allocateApprove(ActionEvent event){

		try { 

			Class clazz = dataTable.getRowData().getClass(); 
			System.out.println("###################################" + clazz );

			AllocationRequest ar = (AllocationRequest ) dataTable.getRowData();
			System.out.println("################allocation req " + ar.getRequest_id() );
			selectedEmployee = ar.getEmployee();
			System.out.println("################allocation req2 " + selectedEmployee.getEmployee_id() );

			/*selectedEmployee = employeeService.getEmployeeDetails( this.selectedEmployee.getEmployee_id() );

			Employee employeeOnLeave = selectedEmployee.getAllocationRequests().get(0).getOutofoffice().getEmployee();
			ParkingSpace psOfEmployeeOnLeave = employeeOnLeave.getPermParking().getParkingspace();
			//OutOfOffice outOffice = selectedEmployee.getA

			ParkingAllocation tempAllocation = new ParkingAllocation();

			tempAllocation.setEnd_date(endDate);
			tempAllocation.setIs_permanent(false);
			tempAllocation.setParkingspace(psOfEmployeeOnLeave);

			selectedEmployee.addParkingAllocation(tempAllocation);

			employeeService.UpdateEmployee(selectedEmployee); */

			return "comWorkForToday";
		} catch (Throwable e) 
		{	
			e.printStackTrace();
			return "comSystemDown";
		}
	}
	
	// Revoke parking request implementation
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

	
	    //Add New Allocation 
		public String addNewAllocation(ActionEvent event){
			
			try {
				selectedEmployee = employeeService.getEmployeeDetails( this.selectedEmployee.getEmployee_id() );
				//selectedEmployee.addAllocation(parkingSpace, block, fromDate, untilDate);
				employeeService.UpdateEmployee(selectedEmployee);
				 
				return "comAllEmployee";
			} catch (Throwable e) 
			{	
				e.printStackTrace();
				return "comSystemDown";
			}	
		}

	

    // GETTERS AND SETTERS
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
