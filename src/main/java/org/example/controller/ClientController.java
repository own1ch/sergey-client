package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.ClientDto;
import org.example.entity.Client;
import org.example.repository.ClientRepo;
import org.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ClientController {
	@Autowired
	private ClientService clientService;

	@Autowired
	private ObjectMapper objectMapper;

	private ClientRepo clientRepository;

	@Autowired
	public void setClientRepository(ClientRepo clientRepository) {
		this.clientRepository = clientRepository;
	}


	@PostMapping(value = "/clients")
	public List<Client> saveClients(@RequestBody List<ClientDto> dtos) {
		return clientService.saveClients(dtos);
	}

	@PostMapping(value = "/save")
	public Client save(@RequestBody Client client) {
		return clientService.save(client);
	}

	@PostMapping(value = "/delete")
	public void delete(@RequestBody Client client) {
		clientService.delete(client);
	}

	@PostMapping(value = "/id")
	public Client mindById(@RequestParam(value = "id", required = false) UUID id) {
		return clientService.mindById(id);
	}


	@GetMapping("delete")
	public void deleteAll() {
		clientService.deleteAll();
	}

	@GetMapping("get")
	public List<Client> findAll() {
		return clientService.findAll();
	}

	@GetMapping("count")
	public long count() {
		return clientService.count();
	}

}
