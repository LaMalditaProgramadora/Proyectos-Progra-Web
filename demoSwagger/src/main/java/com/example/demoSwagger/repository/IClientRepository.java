package com.example.demoSwagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoSwagger.model.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> {

}
