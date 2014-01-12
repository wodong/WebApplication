package com.oracle.staffmanagement.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Employee implements java.io.Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employee_id;
	
	private String employee_no;
	private String firstname;
	private String lastname;
	private String password;
	private String employment_status;
	 
	
	@Temporal(TemporalType.DATE)
	private Date application_date;
	
	@Temporal(TemporalType.DATE)
	private Date allocation_exp_date;
	
	// Relationships tables annotations
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="employee_employee_id")
	private List<Note> notes;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="employee_employee_id")
	private Set<OutOfOffice> outOffice;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="employee_employee_id")
	private List<Contact> contactDetails;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="employee_employee_id")
	private List<Car> employeeCar;
	
	
	public Employee() 
	{
		// required by JPA, but not used by us.		  
	}
	
	
	//Add Employee object to DB along with the Note, OutOfOffice, contact details.
	public Employee(String employee_no, String firstname, String lastname, String password, 
			Date application_date, String employment_status, Date allocation_exp_date) 
	{
		super();
		this.notes = new ArrayList<Note>();
		this.outOffice = new HashSet<OutOfOffice>();
		this.contactDetails = new ArrayList<Contact>();
		this.employeeCar = new ArrayList<Car>();
		
		this.employee_no = employee_no;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.application_date = application_date;
		this.employment_status = employment_status;
		this.allocation_exp_date = allocation_exp_date;
	}

	public String toString()
	{
		return "Employee " + this.employee_no + " " + this.firstname;
	}
	

	//Add Contact details
	public void addContact(String conCompany, String conEmail, int conPhoneNumber, 
			String conLineManager, int conPostCode, String conLineOfBusiness)
	{
		Contact newContact = new Contact(conCompany, conEmail, conPhoneNumber, 
							conLineManager, conPostCode, conLineOfBusiness);
		this.contactDetails.add(newContact);

	}
	
	//add Car details
	public void addCar(String vehicle_regno, String make, String model, String colour, 
			Date date_vehicle_added, String carMotorbikeSpace, String stickernumber)
	{
		Car newCar  = new Car(vehicle_regno, make, model, colour, date_vehicle_added, carMotorbikeSpace, 
			stickernumber);
		this.employeeCar.add(newCar);
		
	}
	
	//Add OutOfOffice
	public void addOutOfOffice(Date out, Date in)
	{
		OutOfOffice newOutOfOffice = new OutOfOffice(out, in);
		this.outOffice.add(newOutOfOffice);	
	}
	
	//Add Note
	public void addNote(String newNoteText)
	{
		Note newNote = new Note(newNoteText);
		this.notes.add(newNote);
	}
    
	/*********Getter and Setters************/
	
	//Getter and Setters  CONTACT
	public List<Contact> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<Contact> contactDetails) {
		this.contactDetails = contactDetails;
	}
	
	public List<Contact> getAllContactDetails() 
	{
		return this.contactDetails;
	}
	
	
    ////Getter and Setters  CAR
	public List<Car> getEmployeeCar() {
		return employeeCar;
	}

	public void setEmployeeCar(List<Car> employeeCar) {
		this.employeeCar = employeeCar;
	}

	//Getter and Setters  OUT OFF OFFICE
	public Set<OutOfOffice> getOutOffice() {
		return outOffice;
	}

	public void setOutOffice(Set<OutOfOffice> outOffice) {
		this.outOffice = outOffice;
	}

	//Getter and Setters  NOTE
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Note> getAllNotes() 
	{
		return this.notes;
	}
	
	//Getters and Setters EMPLOYEE
	public String getEmployee_no() {
		return employee_no;
	}

	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getApplication_date() {
		return application_date;
	}

	public void setApplication_date(Date application_date) {
		this.application_date = application_date;
	}

	public String getEmployment_status() {
		return employment_status;
	}

	public void setEmployment_status(String employment_status) {
		this.employment_status = employment_status;
	}

	public Date getAllocation_exp_date() {
		return allocation_exp_date;
	}

	public void setAllocation_exp_date(Date allocation_exp_date) {
		this.allocation_exp_date = allocation_exp_date;
	}

}
