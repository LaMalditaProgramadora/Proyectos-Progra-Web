package com.example.demoSecurity.service;

import java.util.List;

import com.example.demoSecurity.model.Product;

public interface IProductService {
	public void insert(Product product);
	public List<Product> listAll();
}
