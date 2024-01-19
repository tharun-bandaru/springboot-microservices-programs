package com.tcs.api.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello/{username}")
	public ResponseEntity<String> sayHello(@PathVariable String username)
	{
		String message="Hello "+username+" welcome to REST API";
		ResponseEntity<String> responseEntity=new ResponseEntity<>(message, HttpStatus.OK);
		return responseEntity;
	}
}
