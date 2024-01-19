package com.tcs.register.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.register.entity.CustomerEntity;
import com.tcs.register.model.RegistrationRequest;
import com.tcs.register.repository.CustomerRepository;

@Service
public class RegistrationService {

	@Autowired
	CustomerRepository repo;

	/*
	 *adding the requesting data to the customer object and store in the database
	 * using repo.save(customer)
	 * 
	 * BeanUtils.copyProperties:
	 * copy the properties from source to target i.e request object to customer object
	 */
	public Integer saveCustomer(RegistrationRequest request)
	{
		CustomerEntity customer=new CustomerEntity();
		BeanUtils.copyProperties(request, customer);
		CustomerEntity entity=repo.save(customer);
		return entity.getCustomerId();
	}
}
