package com.example.mappingconcept.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mappingconcept.entity.Employee;
import com.example.mappingconcept.entity.EmployeeDetails;

public interface EmployeeRepository extends JpaRepository<Employee, EmployeeDetails>{

	public boolean existsByEmployeeDetailsEmail(String email);
	
	public boolean existsByEmpCode(Long code);
	
	public Employee findByEmpCode(Long code);
	
	public Employee findByEmployeeDetailsEmail(String email);
	
	List<Employee> findAllByOrderByEmpCodeAsc();
	
//	@Query("SELECT new package com.example.mappingconcept.dto.EmployeeDetailsResponseDTO(e.empCode, e.employeeDetails.name, e.employeeDetails.phone, e.employeeDetails.email, e.city, e.state, e.country, e.company, d.designationDetails.designationCode, d.designationDetails.designationName, d.designationDescription) FROM Employee e JOIN e.designation d WHERE e.empCode = :empCode")
//	EmployeeDetailsResponseDTO findEmployeeDetailsWithDesignation(@Param("empCode") Long empCode);
}
