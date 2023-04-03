package com.cbar.orderhutbe.controller;

import com.cbar.orderhutbe.model.Client;
import com.cbar.orderhutbe.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Client>> retrieveClients() {
        return ResponseEntity.ok()
                .body(clientService.retrieveClients());
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> retrieveClientById(@PathVariable int clientId) {
        return ResponseEntity.ok()
                .body(clientService.retrieveClientById(clientId));
    }

    @PostMapping("/new")
    public ResponseEntity<Client> saveNewClient(@RequestBody Client client) {
        return ResponseEntity.created(URI.create("client" + client.getClientId()))
                .body(clientService.saveNewClient(client));
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> editClient(@PathVariable int clientId,
                                             @RequestBody Client client) {
        return ResponseEntity.created(URI.create("/client" + clientId))
                .body(clientService.editClient(clientId, client));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClientById(@PathVariable int clientId) {
        return ResponseEntity.ok()
                .body(clientService.deleteClientById(clientId));
    }
}
