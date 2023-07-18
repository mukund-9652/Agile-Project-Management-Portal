package com.mukund.AgileProjectManagementPortal.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukund.AgileProjectManagementPortal.exception.InvalidResourceException;
import com.mukund.AgileProjectManagementPortal.exception.MaximumResourceLimitReachedException;
import com.mukund.AgileProjectManagementPortal.model.ResourcesDTO;
import com.mukund.AgileProjectManagementPortal.repository.ResourcesRepository;
import com.mukund.AgileProjectManagementPortal.service.ResourcesService;
import com.mukund.AgileProjectManagementPortal.service.mapper.ProjectsMapper;
import com.mukund.AgileProjectManagementPortal.service.mapper.ResourcesMapper;

@Service
public class ResourcesServiceImpl implements ResourcesService {

	@Autowired
	ResourcesRepository resourcesRepository;
	
	@Autowired
	ProjectsServiceImpl projectsService;
	
	@Autowired
	ProjectsMapper projectsMapper;
	
	@Autowired
	ResourcesMapper resourcesMapper;
	
	@Override
	public String createResources(ResourcesDTO resourcesDTO) throws MaximumResourceLimitReachedException, InvalidResourceException{
		// TODO Auto-generated method stub
		String status=projectsService.getProjectById(resourcesDTO.getProjects().getProjectCode()).getStatus();
		
		if (status.equalsIgnoreCase("Cancelled")|| status.equalsIgnoreCase("completed")) {
			throw new InvalidResourceException("The given project has been completed");
		}
		
		int members=this.resourcesRepository.getByProject(projectsMapper.convertDtoToEntity(resourcesDTO.getProjects()).getProjectCode()).size();
		
		if(members>50 && resourcesDTO.getRole().equalsIgnoreCase("developer")) {
			throw new MaximumResourceLimitReachedException("There can be only 50 Developers");
		}
		else if((members>10 && resourcesDTO.getRole().equalsIgnoreCase("testers"))) {
			throw new MaximumResourceLimitReachedException("There can be only 10 Testers");
		}
		
		resourcesRepository.save(resourcesMapper.convertDtoToEntity(resourcesDTO));
		
		return resourcesDTO.getUserId();
	}

	@Override
	public List<ResourcesDTO> getAllReources() {
		// TODO Auto-generated method stub
		
		return this.resourcesMapper.convertEntityToDto(this.resourcesRepository.findAll());
	}

}
