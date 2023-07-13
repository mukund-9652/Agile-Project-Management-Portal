package com.mukund.AgileProjectManagementPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mukund.AgileProjectManagementPortal.entity.Projects;

public interface ProjectsRepository extends JpaRepository<Projects, Long> {

}
