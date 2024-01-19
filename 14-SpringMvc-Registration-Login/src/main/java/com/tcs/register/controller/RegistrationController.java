package com.tcs.register.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tcs.register.model.RegistrationRequest;
import com.tcs.register.service.EmailService;
import com.tcs.register.service.RegistrationService;

import lombok.Data;

@Controller
@RequestMapping(path="/register")
@Data
public class RegistrationController {

	@Autowired
	RegistrationService service;
	
	@Autowired
	EmailService emailService;

	@GetMapping("/index")
	public String getIndexPage()
	{
		return "index";
	}

	@GetMapping("/page")
	public String getRegistrationPage(Model model)
	{
		RegistrationRequest customer=new RegistrationRequest();
		model.addAttribute("customer", customer);
		return "registration";
	}

	@PostMapping("/save")
	public String addCustomer(@Valid @ModelAttribute("customer") RegistrationRequest customerDto,BindingResult result,Model model) {

		System.out.println("save method");
		if(result.hasErrors()) {
			//model.addAttribute("customer", customerDto);
			return "registration";
		}
		Integer customerId = service.saveCustomer(customerDto);
		emailService.sendEmail(customerDto.getCustomerName(), customerDto.getEmail(), customerId);
		model.addAttribute("customerId", customerId);
		return "registration_success";
		
	}

}
