package com.mukund.AgileProjectManagementPortal.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukund.AgileProjectManagementPortal.exception.DuplicateResourceException;
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
	public boolean addProject(ProjectsDTO projectsDTO) throws DuplicateResourceException {
		// TODO Auto-generated method stub
		boolean checkData=this.projectsRepository.findById(projectsDTO.getProjectCode()).isPresent();
		if(checkData) {
			throw new DuplicateResourceException("Duplicate Resource Found!");
		}
		else {
			this.projectsRepository.save(projectsMapper.convertDtoToEntity(projectsDTO));
			return true;
		}
	}
	
	
	public ProjectsDTO getProjectById(long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		boolean checkData=this.projectsRepository.findById(id).isPresent();
		if(checkData) {
			return this.projectsMapper.convertEntityToDto(this.projectsRepository.findById(id).get());
		}
		else {
			throw new ResourceNotFoundException("No data found for given id!");
		}
	}

	@Override
	public boolean updateProject(long id, ProjectsDTO projectsDTO) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		boolean checkData=this.projectsRepository.findById(id).isPresent();
		if(checkData) {
			this.projectsRepository.save(projectsMapper.convertDtoToEntity(projectsDTO));
			return true;
		}
		else {
			throw new ResourceNotFoundException("No data found for given id!");
		}
	}

	@Override
	public long addProject(ResourcesDTO resourcesDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
