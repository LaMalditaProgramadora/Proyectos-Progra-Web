package com.example.demoImage.repository;

import com.example.demoImage.model.Meme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemeRepository extends JpaRepository<Meme, Integer> {

}
