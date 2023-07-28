package com.lmp.demoJWTSecurity.service;

import java.util.List;

import com.lmp.demoJWTSecurity.model.Users;

public interface IUserService {
    public Users save(Users user);
    List<Users> findAll();
}
