package com.mukund.AgileProjectManagementPortal.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukund.AgileProjectManagementPortal.entity.Projects;
import com.mukund.AgileProjectManagementPortal.model.ProjectsDTO;

@Service
public class ProjectsMapper {
	@Autowired
	ClientsMapper clientsMapper;

	public ProjectsDTO convertEntityToDto(Projects project) {
		ProjectsDTO result = new ProjectsDTO(project.getProjectCode(), project.getTitle(), project.getBudget(),
				project.getStartDate(), project.getExpectedEndDate(), project.getCreatedOn(), project.getStatus(),
				clientsMapper.convertEntityToDto(project.getClients()));

		return result;
	}

	public List<ProjectsDTO> convertEntityToDto(List<Projects> projects) {
		List<ProjectsDTO> result = new ArrayList<>();
		projects.forEach(project -> {
			result.add(this.convertEntityToDto(project));
		});
		return result;
	}

	public Projects convertDtoToEntity(ProjectsDTO projectDTO) {
		Projects result = new Projects(projectDTO.getProjectCode(), projectDTO.getTitle(), projectDTO.getBudget(),
				projectDTO.getStartDate(), projectDTO.getExpectedDate(), projectDTO.getCreatedOn(),
				projectDTO.getStatus(), clientsMapper.convertDtoToEntity(projectDTO.getClients()));

		return result;
	}

	public List<Projects> convertDtoToEntity(List<ProjectsDTO> projectsDTO) {
		List<Projects> result = new ArrayList<>();
		projectsDTO.forEach(projectDTO -> {
			result.add(this.convertDtoToEntity(projectDTO));
		});
		return result;
	}
}
