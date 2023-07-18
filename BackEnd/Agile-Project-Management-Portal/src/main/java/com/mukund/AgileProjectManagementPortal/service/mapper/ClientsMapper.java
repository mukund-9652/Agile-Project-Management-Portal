package com.mukund.AgileProjectManagementPortal.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mukund.AgileProjectManagementPortal.entity.Clients;
import com.mukund.AgileProjectManagementPortal.model.ClientsDTO;

@Service
public class ClientsMapper {
	public ClientsDTO convertEntityToDto(Clients client) {
		ClientsDTO resultDTO = new ClientsDTO(client.getId(), client.getName(), client.getPOC_FullName(),
				client.getPOC_PhoneNumber(), client.getPOC_EmailAddress());
		return resultDTO;

	}

	public Clients convertDtoToEntity(ClientsDTO clientDTO) {
		Clients result = new Clients(clientDTO.getId(), clientDTO.getName(), clientDTO.getPOC_FullName(),
				clientDTO.getPOC_PhoneNumber(), clientDTO.getPOC_EmailAddress());
		return result;

	}

	public List<ClientsDTO> convertEntityToDto(List<Clients> clients) {
		List<ClientsDTO> resultDTOList = new ArrayList<>();
		clients.forEach(client -> {
			resultDTOList.add(this.convertEntityToDto(client));
		});
		return resultDTOList;
	}

	public List<Clients> convertDtoToEntity(List<ClientsDTO> clientsDTO) {
		List<Clients> resultList = new ArrayList<>();
		clientsDTO.forEach(client -> {
			resultList.add(this.convertDtoToEntity(client));
		});
		return resultList;
	}
}
