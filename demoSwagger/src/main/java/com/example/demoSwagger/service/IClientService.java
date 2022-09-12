package com.example.demoSwagger.service;

import java.util.List;

import com.example.demoSwagger.model.Client;

public interface IClientService {
	 List<Client> findAll();
	 Client findById(int idClient);
	 Client save(Client client);
	 void deleteById(int idClient);
}
