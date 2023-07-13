package com.mukund.AgileProjectManagementPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukund.AgileProjectManagementPortal.model.ProjectsDTO;
import com.mukund.AgileProjectManagementPortal.service.implementation.ProjectsServiceImpl;

@Validated
@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectsController {
	@Autowired
	private ProjectsServiceImpl projectsServiceImpl;
	
	@GetMapping
	public List<ProjectsDTO> getAllProjects(){
		return this.projectsServiceImpl.getAllProjects();
	}
}
