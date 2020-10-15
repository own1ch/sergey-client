package org.example.repository;

import org.example.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepositoryImpl {
	@Autowired
	private ClientRepository clientRepository;

	public List<Client> saveClients(List<Client> clients) {
		List<Client> result = new ArrayList<>();
		Iterable<Client> iterable = clientRepository.saveAll(clients);
		for (Client str: iterable) {
			result.add(str);
		}
		return result;
	}
}
