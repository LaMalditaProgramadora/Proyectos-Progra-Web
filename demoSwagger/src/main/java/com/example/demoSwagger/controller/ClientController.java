package com.example.demoSwagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demoSwagger.model.Client;
import com.example.demoSwagger.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientService clientService;

	@GetMapping
	public List<Client> listAll() {
		return clientService.findAll();
	}

	@GetMapping("/{idClient}")
	public Client listById(@PathVariable int idClient) {
		return clientService.findById(idClient);
	}

	@PutMapping("/{idClient}")
	public ResponseEntity<?> update(@PathVariable int idClient, @RequestBody Client client) {
		client.setIdClient(idClient);
		Client clientSave = clientService.save(client);
		return ResponseEntity.ok(clientSave);
	}

	@PostMapping
	public ResponseEntity<?> register(@RequestBody Client client) {
		Client clientSave = clientService.save(client);
		return ResponseEntity.ok(clientSave);
	}

	@DeleteMapping("/{idClient}")
	public ResponseEntity<?> deleteById(@PathVariable int idClient) {
		clientService.deleteById(idClient);
		return ResponseEntity.ok(null);
	}
}
