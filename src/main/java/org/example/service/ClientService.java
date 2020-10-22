package org.example.service;

import org.example.dto.ClientDto;
import org.example.entity.Client;
import org.example.repository.ClientRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
	@Autowired
	private ClientRepositoryImpl clientRepository;

	public List<Client> saveClients(List<ClientDto> clientDtos) {
		List<Client> clients = new ArrayList<>();
		for(ClientDto dto: clientDtos) {
			if(dto.getName().length() >= 5) {
				Client client = new Client();
				client.setId(UUID.randomUUID());
				client.setName(dto.getName());
				client.setSurname(dto.getSurname());
				clients.add(client);
			}
		}

		return clientRepository.saveClients(clients);
	}
	public Client getById(UUID id) {
		return clientRepository.getById(id);
	}

	public void delete(Client client) {
		clientRepository.delete(client);
	}

	public Client save(Client client) {
		return clientRepository.save(client);
	}


	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public void deleteAll() {
		clientRepository.deleteAll();
	}

	public long count() {
		return clientRepository.count();
	}
}
