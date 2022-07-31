package com.example.demoJPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demoJPA.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public String goCustomers(Model model) {
		try {
			model.addAttribute("customers", customerService.listAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customer/customers";
	}

	@GetMapping("/searchByQueryNative")
	public String searchCustomerQueryNative(@RequestParam("fullNameQueryNative") String fullName, Model model) {
		try {
			model.addAttribute("customers", customerService.searchByFullNameQueryNative(fullName));
			System.out.println("Search by Query Native: " + fullName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customer/customers";
	}

	@GetMapping("/searchByQueryJPQL")
	public String searchCustomerQueryJPQL(@RequestParam("fullNameQueryJPQL") String fullName, Model model) {
		try {
			model.addAttribute("customers", customerService.searchByFullNameQueryJPQL(fullName));
			System.out.println("Search by Query JPQL: " + fullName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customer/customers";
	}

	@GetMapping("/searchBySpringDataJPA")
	public String searchCustomerSpringDataJPA(@RequestParam("fullNameSpringDataJPA") String fullName, Model model) {
		try {
			model.addAttribute("customers", customerService.findByFullNameContainingIgnoreCase(fullName));
			System.out.println("Search by Query Spring Data JPA: " + fullName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customer/customers";
	}
}
