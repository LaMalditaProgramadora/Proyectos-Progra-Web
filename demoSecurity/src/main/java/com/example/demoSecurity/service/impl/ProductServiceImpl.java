package com.example.demoSecurity.service.impl;

import java.util.List;

import com.example.demoSecurity.model.Product;
import com.example.demoSecurity.repository.IProductRepository;
import com.example.demoSecurity.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	@Override
	public void insert(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> listAll() {
		return productRepository.findAll();
	}
	
	
}
