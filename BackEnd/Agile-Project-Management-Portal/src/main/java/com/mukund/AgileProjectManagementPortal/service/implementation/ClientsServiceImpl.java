package com.mukund.AgileProjectManagementPortal.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukund.AgileProjectManagementPortal.entity.Clients;
import com.mukund.AgileProjectManagementPortal.model.ClientsDTO;
import com.mukund.AgileProjectManagementPortal.repository.ClientsRepository;
import com.mukund.AgileProjectManagementPortal.service.ClientsService;
import com.mukund.AgileProjectManagementPortal.service.mapper.ClientsMapper;

@Service
public class ClientsServiceImpl implements ClientsService {
	
	@Autowired
	private ClientsRepository clientsRepository;
	
	@Autowired
	private ClientsMapper mapper;

	@Override
	public List<ClientsDTO> getAllClients() {
		// TODO Auto-generated method stub
		List<Clients> resultClients=this.clientsRepository.findAll();
		List<ClientsDTO> result=mapper.convertEntityToDto(resultClients);
		return result;
	}

}
