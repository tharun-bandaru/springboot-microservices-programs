package com.micro.customer.dto;

import lombok.Data;

@Data
public class RegisterDTO {

	private Long phoneNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String planId;
}
