package com.example.mappingconcept.mapper;

import org.springframework.beans.BeanUtils;

import com.example.mappingconcept.dto.DesignationRequestDTO;
import com.example.mappingconcept.dto.DesignationResponseDTO;
import com.example.mappingconcept.entity.Designation;
import com.example.mappingconcept.entity.DesignationDetails;

public class DesignationMapper {
	public static Designation modelMapper(DesignationRequestDTO dto) {
		var designationDetails = new DesignationDetails();
		BeanUtils.copyProperties(dto, designationDetails);
		
		var designation = new Designation();
		BeanUtils.copyProperties(dto, designation);
        designation.setDesignationDetails(designationDetails);

        return designation;
	}
	
	public static DesignationResponseDTO dtoMapper(Designation designation) {
		return new DesignationResponseDTO(
				designation.getDesignationDetails().getDesignationCode(), 
				designation.getDesignationDetails().getDesignationName(), 
				designation.getDesignationDescription());
	}
}
