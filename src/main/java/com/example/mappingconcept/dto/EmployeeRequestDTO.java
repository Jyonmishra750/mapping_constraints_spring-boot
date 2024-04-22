package com.example.mappingconcept.dto;

public class EmployeeRequestDTO {
	private Long empCode;
	private String name;
	private String phone;
	private String email;
	private String city;
	private String state;
	private String country;
	private String company;
	private Long designationCode;
	public Long getEmpCode() {
		return empCode;
	}
	public void setEmpCode(Long empCode) {
		this.empCode = empCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Long getDesignationCode() {
		return designationCode;
	}
	public void setDesignationCode(Long designationCode) {
		this.designationCode = designationCode;
	}

	public EmployeeRequestDTO(Long empCode, String name, String phone, String email, String city, String state,
			String country, String company, Long designationCode) {
		super();
		this.empCode = empCode;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.state = state;
		this.country = country;
		this.company = company;
		this.designationCode = designationCode;
	}
	public EmployeeRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
