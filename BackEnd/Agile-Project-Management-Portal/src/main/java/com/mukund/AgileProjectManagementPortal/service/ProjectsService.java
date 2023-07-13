package com.mukund.AgileProjectManagementPortal.service;

import java.util.List;

import com.mukund.AgileProjectManagementPortal.model.ProjectsDTO;
import com.mukund.AgileProjectManagementPortal.model.ResourcesDTO;

public interface ProjectsService {
	List<ProjectsDTO> getAllProjects();
	boolean addProject(ProjectsDTO projectsDTO);
	boolean updateProject(long id, ProjectsDTO projectsDTO);
	long addProject(ResourcesDTO resourcesDTO);
}
