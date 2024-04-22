package com.example.mappingconcept.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "designations")
public class Designation {
	
	@EmbeddedId
	private DesignationDetails designationDetails;
	
	@OneToOne
	@Transient
	private Employee employee;
	
	private String designationDescription;

	public DesignationDetails getDesignationDetails() {
		return designationDetails;
	}

	public void setDesignationDetails(DesignationDetails designationDetails) {
		this.designationDetails = designationDetails;
	}

	public String getDesignationDescription() {
		return designationDescription;
	}

	public void setDesignationDescription(String designationDescription) {
		this.designationDescription = designationDescription;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Designation(DesignationDetails designationDetails, String designationDescription, Employee employee) {
		super();
		this.designationDetails = designationDetails;
		this.designationDescription = designationDescription;
		this.employee = employee;
	}

	public Designation() {
		super();
	}
	
}
