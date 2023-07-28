package com.lmp.demoJWTSecurity.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="heroes")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String heroName;
    private String realName;
}
