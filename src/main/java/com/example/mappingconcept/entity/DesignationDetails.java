package com.example.mappingconcept.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class DesignationDetails implements Serializable{
	private Long designationCode;
	private String designationName;
	
	public Long getDesignationCode() {
		return designationCode;
	}
	public void setDesignationCode(Long designationCode) {
		this.designationCode = designationCode;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public DesignationDetails(Long designationCode, String designationName) {
		super();
		this.designationCode = designationCode;
		this.designationName = designationName;
	}
	public DesignationDetails() {
		super();
	}
	
}
