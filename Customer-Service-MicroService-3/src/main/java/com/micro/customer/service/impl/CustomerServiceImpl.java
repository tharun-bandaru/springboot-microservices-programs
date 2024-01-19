package com.micro.customer.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.customer.dto.CustomerDTO;
import com.micro.customer.dto.LoginDTO;
import com.micro.customer.dto.RegisterDTO;
import com.micro.customer.entity.CustomerEntity;
import com.micro.customer.repository.CustomerRepository;
import com.micro.customer.service.CustomerServiceInter;

@Service
public class CustomerServiceImpl implements CustomerServiceInter {

	@Autowired
	CustomerRepository customerRepo;

	/*
	 * without using mapper class
	 * 
	 * data from registerDto will be copied into the customerEntity
	 */

	@Override
	public boolean registerCustomer(RegisterDTO registerDto) {

		CustomerEntity customerEntity=new CustomerEntity();
		BeanUtils.copyProperties(registerDto, customerEntity);
		try {
			customerRepo.save(customerEntity);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;

	}

	/*
	 * To login the customer , to check whether the customer details are matched?
	 */

	@Override
	public boolean loginCustomer(LoginDTO loginDto) {
		int count=customerRepo.getCount(loginDto.getPhoneNumber(),loginDto.getPassword());
		if(count==1)
			return true;
		return false;

	}

	/*
	 * data through customerEntity is set to the customerDto
	 * 
	 * BeanUtils.copyProperties(customerEntity, customerDTO): here only the matched properties
	 * will set the properties , remaining will be ignored
	 * 
	 */
	@Override
	public CustomerDTO profile(Long phoneNumber) {

		CustomerEntity customerEntity= customerRepo.findById(phoneNumber).get();
		System.out.println("Profile checked");
		CustomerDTO customerDTO=new CustomerDTO();
		BeanUtils.copyProperties(customerEntity, customerDTO);
		return customerDTO;


	}
	
	@Override
	public String fetchFirstName(Long phoneNumber)
	{	
		CustomerEntity entity=customerRepo.findById(phoneNumber).get();
		
		return entity.getFirstName();
	}

}
