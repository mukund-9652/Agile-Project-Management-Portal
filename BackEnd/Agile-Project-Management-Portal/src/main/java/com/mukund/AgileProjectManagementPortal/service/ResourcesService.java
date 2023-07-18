package com.mukund.AgileProjectManagementPortal.service;

import java.util.List;

import com.mukund.AgileProjectManagementPortal.model.ResourcesDTO;

public interface ResourcesService {
	String createResources(ResourcesDTO resourcesDTO);
	List<ResourcesDTO> getAllReources();
}
