package com.mukund.AgileProjectManagementPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mukund.AgileProjectManagementPortal.entity.Resources;

public interface ResourcesRepository extends JpaRepository<Resources, String> {
	
	@Query(value="SELECT * FROM RESOURCES WHERE PROJECT_CODE = :projectCode",nativeQuery=true)
	List<Resources> getByProject(@Param("projectCode") long projectCode);
}
