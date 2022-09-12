package com.example.demoSwagger.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idClient;

	private String fullName;
	private String phone;
	private String email;
	private Date birthday;
	
}
