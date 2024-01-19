package com.micro.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.micro.customer.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	@Query(value="SELECT COUNT(*) FROM CUSTOMER WHERE phone_number=? and password=?",nativeQuery=true)
	int getCount(Long phoneNumber,String password);
}
