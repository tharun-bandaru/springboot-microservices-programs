package com.tcs.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.app.entities.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{
	

}
