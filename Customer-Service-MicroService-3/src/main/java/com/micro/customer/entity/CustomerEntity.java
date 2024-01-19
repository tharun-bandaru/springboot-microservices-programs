package com.micro.customer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CUSTOMER")
@Data
public class CustomerEntity {

	@Id
	private Long phoneNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String planId;
}
