package com.lmp.demoJWTSecurity.service.impl;

import com.lmp.demoJWTSecurity.model.Hero;
import com.lmp.demoJWTSecurity.repository.IHeroRepository;
import com.lmp.demoJWTSecurity.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements IHeroService {

    @Autowired
    private IHeroRepository heroRepository;


    @Override
    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    @Override
    public Hero save(Hero hero) {
        return heroRepository.save(hero);
    }
}
