package com.example.mappingconcept.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.mappingconcept.dto.EmployeeDetailsResponseDTO;
import com.example.mappingconcept.dto.EmployeeRequestDTO;
import com.example.mappingconcept.mapper.EmployeeMapper;
import com.example.mappingconcept.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
		if (employeeService.existsEmployeeByEmail(employeeRequestDTO.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Email Already Exists."); 
		} else if(employeeService.existsEmployeeByCode(employeeRequestDTO.getEmpCode())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Employee Code Already Exists."); 
		} else {
			var employee = EmployeeMapper.modelMapper(employeeRequestDTO);
			var result = employeeService.saveEmployee(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body(EmployeeMapper.dtoMapper(result));
		}
	}
	
	
	@GetMapping("/allEmployees")
	public List<EmployeeDetailsResponseDTO> getAllDesignations() {
		return employeeService.allEmployees();
	}
	
	@GetMapping("/byEmail")
	public ResponseEntity<?> employeeByEmail(@RequestParam String email) {
			if (employeeService.existsEmployeeByEmail(email)) {
				var result = employeeService.getEmployeeDesignationDetailsByEmployeeEmail(email);
				return ResponseEntity.status(HttpStatus.CREATED).body(result);
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Employee Code Doesn't Exists.");
			}
	}
	
	@GetMapping("/byEmployeeCode")
	public ResponseEntity<?> employeeByEmployeeCode(@RequestParam Long code) {
		if (employeeService.existsEmployeeByCode(code)) {
			var result = employeeService.getEmployeeDesignationDetailsByEmployeeCode(code);
			return ResponseEntity.status(HttpStatus.CREATED).body(result);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Employee Code Doesn't Exists.");
		}
		
	}
	
	
}
