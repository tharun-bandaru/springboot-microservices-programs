package com.tcs.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.register.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

}
