package com.example.mappingconcept.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mappingconcept.dto.EmployeeDetailsResponseDTO;
import com.example.mappingconcept.entity.Employee;
import com.example.mappingconcept.repository.DesignationRepository;
import com.example.mappingconcept.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DesignationRepository designationRepository;
	
	public boolean existsEmployeeByEmail(String email) {
		return employeeRepository.existsByEmployeeDetailsEmail(email);
	}
	
	public boolean existsEmployeeByCode(Long code) {
		return employeeRepository.existsByEmpCode(code);
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	} 
	
	public Employee getByEmployeeCode(Long code) {
		return employeeRepository.findByEmpCode(code);
	}
	
	public List<EmployeeDetailsResponseDTO> allEmployees() {
		List<Employee> employees = employeeRepository.findAllByOrderByEmpCodeAsc();
	    List<EmployeeDetailsResponseDTO> dtos = new ArrayList<>();
	    for (Employee employee : employees) {
	    	EmployeeDetailsResponseDTO dto = new EmployeeDetailsResponseDTO();
	    	dto.setEmpCode(employee.getEmpCode());
	        dto.setName(employee.getEmployeeDetails().getName());
	        dto.setPhone(employee.getEmployeeDetails().getPhone());
	        dto.setEmail(employee.getEmployeeDetails().getEmail());
	        dto.setCity(employee.getCity());
	        dto.setState(employee.getState());
	        dto.setCountry(employee.getCountry());
	        dto.setCompany(employee.getCompany());
	        if (designationRepository.existsByDesignationDetailsDesignationCode(employee.getDesignationCode())) {
	        	var designation = designationRepository.findByDesignationDetailsDesignationCode(employee.getDesignationCode());
				dto.setDesignationCode(designation.getDesignationDetails().getDesignationCode());
				dto.setDesignationName(designation.getDesignationDetails().getDesignationName());
				dto.setDesignationDescription(designation.getDesignationDescription());
			}
	        dtos.add(dto);
	    }
	    return dtos;
	}
	
	public EmployeeDetailsResponseDTO getEmployeeDesignationDetailsByEmployeeCode(Long empCode) {
		if (employeeRepository.existsByEmpCode(empCode)) {
			var employee = employeeRepository.findByEmpCode(empCode);
	    	EmployeeDetailsResponseDTO dto = new EmployeeDetailsResponseDTO();
	        dto.setEmpCode(employee.getEmpCode());
	        dto.setName(employee.getEmployeeDetails().getName());
	        dto.setPhone(employee.getEmployeeDetails().getPhone());
	        dto.setEmail(employee.getEmployeeDetails().getEmail());
	        dto.setCity(employee.getCity());
	        dto.setState(employee.getState());
	        dto.setCountry(employee.getCountry());
	        dto.setCompany(employee.getCompany());
	        if (designationRepository.existsByDesignationDetailsDesignationCode(employee.getDesignationCode())) {
	        	var designation = designationRepository.findByDesignationDetailsDesignationCode(employee.getDesignationCode());
				dto.setDesignationCode(designation.getDesignationDetails().getDesignationCode());
				dto.setDesignationName(designation.getDesignationDetails().getDesignationName());
				dto.setDesignationDescription(designation.getDesignationDescription());
			}
	        return dto;
		} else {
			throw new EntityNotFoundException("Employee not found with empCode: " + empCode);
		}
        
    }
	
	public EmployeeDetailsResponseDTO getEmployeeDesignationDetailsByEmployeeEmail(String email) {
		if (employeeRepository.existsByEmployeeDetailsEmail(email)) {
			var employee = employeeRepository.findByEmployeeDetailsEmail(email);
	    	EmployeeDetailsResponseDTO dto = new EmployeeDetailsResponseDTO();
	        dto.setEmpCode(employee.getEmpCode());
	        dto.setName(employee.getEmployeeDetails().getName());
	        dto.setPhone(employee.getEmployeeDetails().getPhone());
	        dto.setEmail(employee.getEmployeeDetails().getEmail());
	        dto.setCity(employee.getCity());
	        dto.setState(employee.getState());
	        dto.setCountry(employee.getCountry());
	        dto.setCompany(employee.getCompany());
	        if (designationRepository.existsByDesignationDetailsDesignationCode(employee.getDesignationCode())) {
	        	var designation = designationRepository.findByDesignationDetailsDesignationCode(employee.getDesignationCode());
				dto.setDesignationCode(designation.getDesignationDetails().getDesignationCode());
				dto.setDesignationName(designation.getDesignationDetails().getDesignationName());
				dto.setDesignationDescription(designation.getDesignationDescription());
			}
	        return dto;
		} else {
			throw new EntityNotFoundException("Employee not found with email: " + email);
		}
        
    }
}
