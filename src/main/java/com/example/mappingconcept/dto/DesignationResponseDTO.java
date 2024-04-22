package com.example.mappingconcept.dto;

public class DesignationResponseDTO {
	private Long designationCode;
	private String designationName;
	private String designationDescription;
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
	public String getDesignationDescription() {
		return designationDescription;
	}
	public void setDesignationDescription(String designationDescription) {
		this.designationDescription = designationDescription;
	}
	public DesignationResponseDTO(Long designationCode, String designationName, String designationDescription) {
		super();
		this.designationCode = designationCode;
		this.designationName = designationName;
		this.designationDescription = designationDescription;
	}
	public DesignationResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
