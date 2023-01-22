package com.cbar.orderhutbe.service;

import com.cbar.orderhutbe.exceptions.NoElementFoundException;
import com.cbar.orderhutbe.model.Client;
import com.cbar.orderhutbe.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveNewClient(Client client) {
        return  clientRepository.save(client);
    }

    public List<Client> retrieveClients() {
        return clientRepository.findAll();
    }

    public String deleteClientById(int clientId) {
        clientRepository.deleteById(clientId);
        return "OK";
    }

    public Client editClient(int clientId, Client client) {
        Client actualClient = clientRepository.findById(clientId)
                .orElseThrow(() -> new NoElementFoundException("Id not available!"));

        actualClient.setClientName(client.getClientName());

        return clientRepository.save(actualClient);
    }
}
