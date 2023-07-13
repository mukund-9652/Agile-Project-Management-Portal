package com.mukund.AgileProjectManagementPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukund.AgileProjectManagementPortal.exception.ResourceNotFoundException;
import com.mukund.AgileProjectManagementPortal.model.ClientsDTO;
import com.mukund.AgileProjectManagementPortal.service.implementation.ClientsServiceImpl;

@Validated
@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientsController {

	@Autowired
	private ClientsServiceImpl clientsServiceImpl;

	@GetMapping
	public List<ClientsDTO> getAllClients() throws ResourceNotFoundException {
		List<ClientsDTO> resultDTO = clientsServiceImpl.getAllClients();
		if (resultDTO.isEmpty()) {
			throw new ResourceNotFoundException("No Clients Found!!");
		} else {
			return resultDTO;
		}
	}
}
