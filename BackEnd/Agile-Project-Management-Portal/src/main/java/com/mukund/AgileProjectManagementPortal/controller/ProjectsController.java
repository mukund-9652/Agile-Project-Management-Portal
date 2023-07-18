package com.mukund.AgileProjectManagementPortal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukund.AgileProjectManagementPortal.model.ProjectsDTO;
import com.mukund.AgileProjectManagementPortal.model.ResourcesDTO;
import com.mukund.AgileProjectManagementPortal.service.implementation.ProjectsServiceImpl;
import com.mukund.AgileProjectManagementPortal.service.implementation.ResourcesServiceImpl;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectsController {
	@Autowired
	private ProjectsServiceImpl projectsServiceImpl;

	@Autowired
	private ResourcesServiceImpl resourcesServiceImpl;
	
	@GetMapping
	public List<ProjectsDTO> getAllProjects() {
		return this.projectsServiceImpl.getAllProjects();
	}

	@PostMapping("/new")
	public ResponseEntity<Void> addProjects(@Valid @RequestBody ProjectsDTO request) {
		boolean addStatus=this.projectsServiceImpl.addProject(request);
		if(addStatus) {			
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/resources/{id}")
	public List<ResourcesDTO> getAllResources(@PathVariable String id) {
		if(id.equalsIgnoreCase("adM"))
			return this.resourcesServiceImpl.getAllReources();
		else
			return new ArrayList<ResourcesDTO>();
	}
	
	@PostMapping("/addResources")
	public ResponseEntity<String> addResources(@Valid @RequestBody ResourcesDTO request) {
		String addStatus=this.resourcesServiceImpl.createResources(request);
		if(!addStatus.isEmpty()) {			
			return ResponseEntity.ok(addStatus);
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{projectCode}/update")
	public ResponseEntity<Void> updateProjects(@PathVariable long projectCode,@Valid @RequestBody ProjectsDTO request) {
		boolean updateStatus=this.projectsServiceImpl.updateProject(projectCode,request);
		if(updateStatus) {			
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
}
