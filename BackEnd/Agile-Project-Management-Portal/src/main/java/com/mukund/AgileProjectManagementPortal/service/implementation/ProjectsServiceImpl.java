package com.mukund.AgileProjectManagementPortal.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukund.AgileProjectManagementPortal.exception.ResourceNotFoundException;
import com.mukund.AgileProjectManagementPortal.model.ProjectsDTO;
import com.mukund.AgileProjectManagementPortal.model.ResourcesDTO;
import com.mukund.AgileProjectManagementPortal.repository.ProjectsRepository;
import com.mukund.AgileProjectManagementPortal.service.ProjectsService;
import com.mukund.AgileProjectManagementPortal.service.mapper.ProjectsMapper;

@Service
public class ProjectsServiceImpl implements ProjectsService {

	@Autowired
	private ProjectsRepository projectsRepository;

	@Autowired
	private ProjectsMapper projectsMapper;

	@Override
	public List<ProjectsDTO> getAllProjects() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<ProjectsDTO> projectsDTO = this.projectsMapper.convertEntityToDto(this.projectsRepository.findAll());
		if (projectsDTO.isEmpty()) {
			throw new ResourceNotFoundException("No Data Found in the Table. Check the Database");
		} else {
			return projectsDTO;
		}
	}

	@Override
	public boolean addProject(ProjectsDTO projectsDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProject(long id, ProjectsDTO projectsDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long addProject(ResourcesDTO resourcesDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
