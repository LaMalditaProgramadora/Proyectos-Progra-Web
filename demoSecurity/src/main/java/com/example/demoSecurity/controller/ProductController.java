package com.example.demoSecurity.controller;

import java.text.ParseException;

import com.example.demoSecurity.model.Product;
import com.example.demoSecurity.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@RequestMapping
	public String goProducts(Model model) {
		model.addAttribute("listProducts", productService.listAll());
		return "products/listProducts";
	}

	@RequestMapping("/new")
	public String goNewProduct(Model model) {
		model.addAttribute("product", new Product());
		return "products/product";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute Product product, BindingResult binRes, Model model) throws ParseException {
		try {
			productService.insert(product);
			return "redirect:/products";
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "products/product";
		}
	}
}
