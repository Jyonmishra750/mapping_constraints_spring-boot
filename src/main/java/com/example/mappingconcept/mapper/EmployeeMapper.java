package com.example.mappingconcept.mapper;

import org.springframework.beans.BeanUtils;
import com.example.mappingconcept.dto.EmployeeRequestDTO;
import com.example.mappingconcept.dto.EmployeeResponseDTO;
import com.example.mappingconcept.entity.DesignationDetails;
import com.example.mappingconcept.entity.Employee;
import com.example.mappingconcept.entity.EmployeeDetails;

public class EmployeeMapper {
	
	public static Employee modelMapper(EmployeeRequestDTO dto) {
		var employeeDetails = new EmployeeDetails();
		BeanUtils.copyProperties(dto, employeeDetails);
		
		var employee = new Employee();
		BeanUtils.copyProperties(dto, employee);
        employee.setEmployeeDetails(employeeDetails);
        employee.setDesignationCode(dto.getDesignationCode());
        
        var designationDetails = new DesignationDetails();
		designationDetails.setDesignationCode(dto.getDesignationCode());
		
        return employee;
    }
	
	public static EmployeeResponseDTO dtoMapper(Employee employee) {
		return new EmployeeResponseDTO(
				employee.getEmpCode(),
				employee.getEmployeeDetails().getName(),
				employee.getEmployeeDetails().getPhone(),
				employee.getEmployeeDetails().getEmail(),
				employee.getCity(),
				employee.getState(),
				employee.getCountry(),
				employee.getCompany(),
				employee.getDesignationCode());
	}
}
