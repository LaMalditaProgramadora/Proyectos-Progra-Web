package com.example.demoSwagger.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoSwagger.model.Client;
import com.example.demoSwagger.repository.IClientRepository;
import com.example.demoSwagger.service.IClientService;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientRepository clientRepository;
	
	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client findById(int idClient) {
		return clientRepository.findById(idClient).get();
	}

	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void deleteById(int idClient) {
		clientRepository.deleteById(idClient);
	}

}
