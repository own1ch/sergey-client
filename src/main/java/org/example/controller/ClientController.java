package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.ClientDto;
import org.example.dto.IdDto;
import org.example.entity.Client;
import org.example.repository.ClientRepo;
import org.example.repository.ClientRepositoryImpl;
import org.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ClientController {

    @Autowired
    private ClientRepositoryImpl sd;
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

    @PostMapping
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @DeleteMapping
    public void delete(@RequestBody List<UUID> ids) {
        //clientService.delete(client);
    }

    @PutMapping
    public Client update(@RequestBody String idDto) {
        //clientService.save()
        return null;
    }



//	@PostMapping(value = "/{id}")
//	public Client getById(@PathVariable(value = "id") UUID id) {
//		return clientService.getById(id);
//	}

    @GetMapping(value = "")
    public String getById(@RequestParam UUID id, @RequestParam(name = "surname") String[] surname) {
        //return clientService.getById(id);
        return id + " " + surname[0];
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public String getEmployeesById(@PathVariable UUID id) {
        return "ID: " + id;
    }

    @PostMapping(value = "zalupa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client getById(@RequestBody UUID id) {
        return clientService.getById(id);
    }

    @DeleteMapping("delete")
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
