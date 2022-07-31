package com.example.demoJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demoJPA.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	// Query Nativo (como se ejecutaría en SQL)
	@Query(value = "select * from customer c where upper(c.full_name) like upper(concat('%', ?1,'%'))", nativeQuery = true)
	List<Customer> searchByFullNameQueryNative(String fullName);

	// JPQL (lenguaje de consulta de persistencia de Java)
	@Query("from Customer c where upper(c.fullName) like upper(concat('%', :fullName,'%'))")
	List<Customer> searchByFullNameQueryJPQL(@Param("fullName") String fullName);

	// Spring Data JPA (framework Spring)
	// Sintaxis: findBy + Atributo (la primera letra en mayúscula) + Containing + IgnoreCase
	List<Customer> findByFullNameContainingIgnoreCase(String fullName);

}
