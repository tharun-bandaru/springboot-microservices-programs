package com.micro.ui.model;

import java.util.List;

import lombok.Data;

@Data
public class RegisterDTO {

	private Long phoneNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String planId;
	private List<PlanDTO> planData;
}
