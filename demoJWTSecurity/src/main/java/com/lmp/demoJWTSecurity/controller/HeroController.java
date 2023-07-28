package com.lmp.demoJWTSecurity.controller;

import com.lmp.demoJWTSecurity.model.Hero;
import com.lmp.demoJWTSecurity.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/heroes")
@CrossOrigin
public class HeroController {
    @Autowired
    private IHeroService heroService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(heroService.findAll());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> save(@RequestBody Hero hero) {
        return ResponseEntity.ok(heroService.save(hero));
    }
}
