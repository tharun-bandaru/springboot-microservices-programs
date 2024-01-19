package com.tcs.register.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RegistrationRequest {
	
	@NotEmpty
	private String customerName;
	
	@NotEmpty
	@Size(min=5, max=12)
	private String password;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	private Long contact;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date dateOfBirth;
}
