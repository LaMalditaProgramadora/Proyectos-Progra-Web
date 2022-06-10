package com.example.demoSecurity.service.impl;

import java.util.ArrayList;

import com.example.demoSecurity.model.Role;
import com.example.demoSecurity.model.Users;
import com.example.demoSecurity.repository.IRoleRepository;
import com.example.demoSecurity.repository.IUsersRepository;
import com.example.demoSecurity.service.IUsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements IUsersService {

	@Autowired
	private IUsersRepository userRepository;

	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void insert(Users user) {
		Users objUser = user;
		objUser.setPassword(passwordEncoder.encode(objUser.getPassword()));
		objUser.setEnabled(true);
		Role role = new Role();
		// Se asigna el rol con el que queremos que el usuario se cree
		role.setAuthority("ROLE_USER");
		role = roleRepository.save(role);

		objUser.setRoles(new ArrayList<Role>());
		objUser.getRoles().add(role);
		objUser = userRepository.save(objUser);
	}

}
