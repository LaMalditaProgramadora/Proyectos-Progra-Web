package com.example.demoSecurity.controller;

import java.text.ParseException;

import com.example.demoSecurity.model.Users;
import com.example.demoSecurity.service.IUsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private IUsersService userService;
	
	@RequestMapping("/new")
	public String goNewUser(Model model) {
		model.addAttribute("user", new Users());
		return "users/user";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute Users user, BindingResult binRes, Model model) throws ParseException {
		try {
			userService.insert(user);
			return "redirect:/login";
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "users/user";
		}
	}
}
