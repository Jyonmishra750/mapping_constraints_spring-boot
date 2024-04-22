package com.example.mappingconcept.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mappingconcept.entity.Designation;
import com.example.mappingconcept.entity.DesignationDetails;

public interface DesignationRepository extends JpaRepository<Designation, DesignationDetails>{
	public boolean existsByDesignationDetailsDesignationCode(Long code);
	public Designation findByDesignationDetailsDesignationCode(Long code);
}
