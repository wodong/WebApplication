package com.oracle.backingbeans;

import com.oracle.staffmanagement.EmployeeManagementServiceLocal;
import com.oracle.staffmanagement.dataaccess.UserDAO;
import com.oracle.staffmanagement.domain.Employee;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
 
@ManagedBean(name = "loginBean")
@SessionScoped
/**
 *
 * @author User
 */
public class LoginBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private String password;
    private String message, uname;
 
    @EJB
	private EmployeeManagementServiceLocal employeeService;
    private Employee selectedEmployee;
    
    public LoginBean() {
		selectedEmployee = new Employee();
	}
    
    public Employee searchByEmployeeNoo(String employee_no)
	{	
	 return employeeService.searchByEmployeeNoo(employee_no);
	}
    
    public Employee searchByEmployeeNo(String employee_no)
	{	
	 return employeeService.searchByEmployeeNo(employee_no);
	}
    
    
   public boolean userValidation(){
    	
    	Employee employee = searchByEmployeeNo(getUname());
        selectedEmployee = (Employee) employee;
        String dbPassword = new String(this.selectedEmployee.getPassword());
    	String userPassword  = new String(getPassword());
    	if(dbPassword.equals(userPassword)){
    		
    		return true;
    	} else {
    		return false;
    	}
    	
    }
    
  
    public String loginProject() {
        
    	boolean result = userValidation();
        if (result) {
            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("username", uname);
   
            return "comAllEmployee";
        } else {
 
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
 
            // invalidate session, and redirect to other pages
 
            //message = "Invalid Login. Please Try Again!";
            return "index";
        }
    }
 
    public String logout() {
      HttpSession session = Util.getSession();
      session.invalidate();
      return "index";
   }
    
    
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }



	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}



	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}
    
    
    
}
