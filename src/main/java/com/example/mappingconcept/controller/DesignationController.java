package com.example.mappingconcept.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.mappingconcept.dto.DesignationRequestDTO;
import com.example.mappingconcept.dto.DesignationResponseDTO;
import com.example.mappingconcept.mapper.DesignationMapper;
import com.example.mappingconcept.service.DesignationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DesignationController {
	
	@Autowired
	private DesignationService designationService;
	
	@PostMapping("/addDesignation")
	public ResponseEntity<?> addDesignation(@RequestBody DesignationRequestDTO designationRequestDTO) {
		if (designationService.existsDesignationCode(designationRequestDTO.getDesignationCode())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Designation Code Already Exists.");
		} else {
			var designation = DesignationMapper.modelMapper(designationRequestDTO);
			var result = designationService.saveDesignation(designation);
			return ResponseEntity.status(HttpStatus.CREATED).body(DesignationMapper.dtoMapper(result));
		}
	
	}
	
	@GetMapping("/allDesignations")
	public List<DesignationResponseDTO> getAllDesignations() {
		return designationService.allDesignations();
	}
	
	@GetMapping("/designationByCode")
	public ResponseEntity<?> getDesignationByCode(@RequestParam Long code) {
		var result = designationService.getDesignationDetailsByDesignationCode(code);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	
}
