package org.example.controller;

import org.example.dto.ClientDto;
import org.example.entity.Client;
import org.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
	@Autowired
	private ClientService clientService;

	@PostMapping
	public List<Client> saveClients(@RequestBody List<ClientDto> dtos) {
		return clientService.saveClients(dtos);
	}

}