package com.micro.customer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.micro.customer.api.feign.FriendProxy;
import com.micro.customer.api.feign.PlanProxy;
import com.micro.customer.dto.CustomerDTO;
import com.micro.customer.dto.LoginDTO;
import com.micro.customer.dto.PlanDTO;
import com.micro.customer.dto.RegisterDTO;
import com.micro.customer.service.CustomerServiceInter;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerAPI {
	
	private static final String PLANDATA_URL = "http://PLAN/api/v1/plans/{id}";
	private static final String FRIENDS_URL = "http://FRIEND/api/v1/friend/view-all/{phoneNo}";
	
	@Autowired
	CustomerServiceInter service;
	
	@Autowired
	PlanProxy pProxy;
	
	@Autowired
	FriendProxy fProxy;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/create")
	public ResponseEntity<Boolean> register(@RequestBody RegisterDTO rDTO) {
		boolean flag = service.registerCustomer(rDTO);
		if(flag)
			return ResponseEntity.status(HttpStatus.CREATED).body(flag);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(flag);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody LoginDTO lDTO) {
		boolean flag = service.loginCustomer(lDTO);
		if(flag)
			return ResponseEntity.status(HttpStatus.OK).body(flag);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(flag);
	}
	
	@GetMapping("/profile/{phoneNumber}")
	public ResponseEntity<CustomerDTO> getProfile(@PathVariable Long phoneNumber) {
		
		CustomerDTO customerDto = service.profile(phoneNumber);
		
		//call Plan-Service to obtain plan data (using RestTemplate)
		/*
		RequestEntity<Void> reqEntity = RequestEntity.get(PLANDATA_URL, customerDto.getPlanId())
				   .accept(MediaType.APPLICATION_JSON)
				   .build();
		ResponseEntity<PlanDTO> re = restTemplate.exchange(reqEntity, PlanDTO.class);
		if(re.getBody() instanceof PlanDTO) {
			customerDto.setPlanData((PlanDTO)re.getBody());
		}
		else {
			customerDto.setFailureMessage("No plan exist with the planid :" +customerDto.getPlanId());
		}
		*/
		
		//call Plan-Service to obtain plan data (using feign)
		ResponseEntity<PlanDTO> re = pProxy.queryPlanData(customerDto.getPlanId());
		customerDto.setPlanData(re.getBody());
		
		
		
		//call Friend-Service to obtain friends contacts(using RestTemplate)
		/*
		ParameterizedTypeReference<List<Long>> typeRef = new ParameterizedTypeReference<List<Long>>() {};
		RequestEntity<Void> reqEntity_2 = RequestEntity.get(FRIENDS_URL, phoneNumber)
				   .accept(MediaType.APPLICATION_JSON)
				   .build();
		ResponseEntity<List<Long>> res = restTemplate.exchange(reqEntity_2, typeRef);
		customerDto.setFriendsContacts(res.getBody());
		*/
		
		//call Friend-Service to obtain friends contacts(using feign)
		ResponseEntity<List<Long>> res = fProxy.queryFriendsContacts(phoneNumber);
		customerDto.setFriendContacts(res.getBody());
		
		return ResponseEntity.ok(customerDto);
		
	}
	
	@GetMapping("/name/{phoneNumber}")
	public String getFirstName(@PathVariable Long phoneNumber) {
		return service.fetchFirstName(phoneNumber);
	}

}
