package com.mukund.AgileProjectManagementPortal.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukund.AgileProjectManagementPortal.entity.Resources;
import com.mukund.AgileProjectManagementPortal.model.ResourcesDTO;

@Service
public class ResourcesMapper {

	@Autowired
	ProjectsMapper projectsMapper;

	public ResourcesDTO convertEntityToDto(Resources resources) {
		ResourcesDTO result = new ResourcesDTO(resources.getUserId(), resources.getFirstName(), resources.getLastName(),
				resources.getEmail(), resources.getPhoneNumber(), resources.getRole(),
				projectsMapper.convertEntityToDto(resources.getProjects()));
		return result;
	}

	public Resources convertDtoToEntity(ResourcesDTO resources) {
		Resources result = new Resources(resources.getUserId(), resources.getFirstName(), resources.getLastName(),
				resources.getEmail(), resources.getPhoneNumber(), resources.getRole(),
				projectsMapper.convertDtoToEntity(resources.getProjects()));
		return result;
	}

	public List<Resources> convertDtoToEntity(List<ResourcesDTO> resources) {
		List<Resources> result = resources.stream().map(i -> this.convertDtoToEntity(i)).collect(Collectors.toList());;
		return result;
	}

	public List<ResourcesDTO> convertEntityToDto(List<Resources> resources) {
		List<ResourcesDTO> result = resources.stream().map(i -> this.convertEntityToDto(i))
				.collect(Collectors.toList());
		;
		return result;
	}

}
