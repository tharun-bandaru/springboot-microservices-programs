package com.micro.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PlanServiceMicroService01Application {

	public static void main(String[] args) {
		SpringApplication.run(PlanServiceMicroService01Application.class, args);
	}

} 
