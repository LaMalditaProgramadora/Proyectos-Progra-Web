package com.example.demoJPA.service;

import java.util.List;

import com.example.demoJPA.model.Customer;

public interface CustomerService {
	
	List<Customer> searchByFullNameQueryNative(String fullName);
	List<Customer> searchByFullNameQueryJPQL(String fullName);
	List<Customer> findByFullNameContainingIgnoreCase(String fullName);
	List<Customer> listAll();
	
}
