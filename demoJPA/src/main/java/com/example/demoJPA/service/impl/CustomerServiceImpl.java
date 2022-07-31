package com.example.demoJPA.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJPA.model.Customer;
import com.example.demoJPA.repository.CustomerRepository;
import com.example.demoJPA.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> searchByFullNameQueryNative(String fullName) {
		return customerRepository.searchByFullNameQueryNative(fullName);
	}

	@Override
	public List<Customer> searchByFullNameQueryJPQL(String fullName) {
		return customerRepository.searchByFullNameQueryJPQL(fullName);
	}

	@Override
	public List<Customer> findByFullNameContainingIgnoreCase(String fullName) {
		return customerRepository.findByFullNameContainingIgnoreCase(fullName);
	}

	@Override
	public List<Customer> listAll() {
		return customerRepository.findAll();
	}

}
