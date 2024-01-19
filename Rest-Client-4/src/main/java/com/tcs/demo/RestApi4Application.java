package com.tcs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestApi4Application {

	public static void main(String[] args) {
		SpringApplication.run(RestApi4Application.class, args);
	}


	/*
	 * RestTemplate class is used to consume the REST API's in spring application
	 */

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	

}
