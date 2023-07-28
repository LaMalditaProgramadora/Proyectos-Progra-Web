package com.lmp.demoJWTSecurity.service.impl;

import com.lmp.demoJWTSecurity.model.Users;
import com.lmp.demoJWTSecurity.repository.IUserRepository;
import com.lmp.demoJWTSecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Users save(Users user) {
        return userRepository.save(user);
    }

}
