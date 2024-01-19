package com.micro.customer.service;

import com.micro.customer.dto.CustomerDTO;
import com.micro.customer.dto.LoginDTO;
import com.micro.customer.dto.RegisterDTO;

public interface CustomerServiceInter {
	
	boolean registerCustomer(RegisterDTO registerDto);
	boolean loginCustomer(LoginDTO loginDto);
	CustomerDTO profile(Long phoneNumber);
	String fetchFirstName(Long phoneNumber);

}
