package com.micro.ui.model;

import java.util.List;

import lombok.Data;

@Data
public class CustomerDTO {

	private Long phoneNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String planId;
	private PlanDTO planData;
	private List<Long> friendContacts;
	private String failureMessage;
}
