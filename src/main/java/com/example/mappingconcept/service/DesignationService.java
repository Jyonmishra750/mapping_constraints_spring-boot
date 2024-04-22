package com.example.mappingconcept.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mappingconcept.dto.DesignationResponseDTO;
import com.example.mappingconcept.entity.Designation;
import com.example.mappingconcept.repository.DesignationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DesignationService {
	@Autowired
	private DesignationRepository designationRepository;
	
	public boolean existsDesignationCode(Long code) {
		return designationRepository.existsByDesignationDetailsDesignationCode(code);
	}

	public Designation saveDesignation(Designation designation) {
		return designationRepository.save(designation);
	}
	
	public List<DesignationResponseDTO> allDesignations() {
		List<Designation> designations = designationRepository.findAll();
	    List<DesignationResponseDTO> dtos = new ArrayList<>();
	    for (Designation designation : designations) {
	        DesignationResponseDTO dto = new DesignationResponseDTO();
	        dto.setDesignationCode(designation.getDesignationDetails().getDesignationCode());
	        dto.setDesignationName(designation.getDesignationDetails().getDesignationName());
	        dto.setDesignationDescription(designation.getDesignationDescription());
	        dtos.add(dto);
	    }
	    return dtos;
	}
	
	public DesignationResponseDTO getDesignationDetailsByDesignationCode(Long degCode) {
		if (designationRepository.existsByDesignationDetailsDesignationCode(degCode)) {
			var designation = designationRepository.findByDesignationDetailsDesignationCode(degCode);
			DesignationResponseDTO dto = new DesignationResponseDTO();
	        dto.setDesignationCode(designation.getDesignationDetails().getDesignationCode());
	        dto.setDesignationName(designation.getDesignationDetails().getDesignationName());
	        dto.setDesignationDescription(designation.getDesignationDescription());
			
	        return dto;
		} else {
			throw new EntityNotFoundException("Employee not found with empCode: " + degCode);
		}
	}
}
