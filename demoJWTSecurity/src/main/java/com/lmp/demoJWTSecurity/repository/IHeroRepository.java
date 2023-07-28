package com.lmp.demoJWTSecurity.repository;

import com.lmp.demoJWTSecurity.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHeroRepository extends JpaRepository<Hero, Integer> {
}
