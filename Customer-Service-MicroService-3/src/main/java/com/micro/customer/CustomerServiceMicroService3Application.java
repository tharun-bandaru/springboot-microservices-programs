package com.micro.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CustomerServiceMicroService3Application {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceMicroService3Application.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate()
	{
		
		return new RestTemplate();
	}

}
