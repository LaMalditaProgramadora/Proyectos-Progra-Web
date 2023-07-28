package com.lmp.demoJWTSecurity.service;

import com.lmp.demoJWTSecurity.model.Hero;

import java.util.List;

public interface IHeroService {
    List<Hero> findAll();
    Hero save(Hero hero);
}
