package com.example.mappingconcept.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "employees")
public class Employee {
	private Long empCode;
	@EmbeddedId
	private EmployeeDetails employeeDetails;
	private String city;
	private String state;
	private String country;
	private String company;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Transient
	private Designation designation;
	
	private Long designationCode;

	
	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}
	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	public Long getEmpCode() {
		return empCode;
	}
	public void setEmpCode(Long empCode) {
		this.empCode = empCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Designation getDesignation() {
		return designation;
	}
	public void setDesignation(Designation designation) {
		this.designation = designation;
	}
	
	public Long getDesignationCode() {
		return designationCode;
    }
	
	public void setDesignationCode(Long designationCode) {
		this.designationCode = designationCode;
	}
	
	public Employee(Long empCode, EmployeeDetails employeeDetails, String city, String state, String country,
			String company, Long designationCode, Designation designation) {
		super();
		this.empCode = empCode;
		this.employeeDetails = employeeDetails;
		this.city = city;
		this.state = state;
		this.country = country;
		this.company = company;
		this.designationCode = designationCode;
		this.designation = designation;
	}
	public Employee() {
		super();
	}
	
	
}
