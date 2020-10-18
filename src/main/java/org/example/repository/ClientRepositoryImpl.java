package org.example.repository;

import org.example.entity.Client;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClientRepositoryImpl {

	private final ClientRepo clientRepository;

	public ClientRepositoryImpl(ClientRepo clientRepository) {
		this.clientRepository = clientRepository;
	}

	public List<Client> saveClients(List<Client> clients) {
		List<Client> result = new ArrayList<>();
		Iterable<Client> iterable = clientRepository.saveAll(clients);
		for (Client str: iterable) {
			result.add(str);
		}
		return result;
	}
	public Client mindById(UUID id) {
		List<Client> clients = clientRepository.findAll();
		for (Client client : clients) {
			if (client.getId().equals(id)) {
				return client;
			}
		}
		return null;
	}

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public void deleteAll() {
		clientRepository.deleteAll();
	}

	public Client save(Client client) {
		clientRepository.save(client);
		return client;
	}


	public void delete(Client client) {
		clientRepository.delete(client);
	}

	public long count() {
		return clientRepository.count();
	}

}
