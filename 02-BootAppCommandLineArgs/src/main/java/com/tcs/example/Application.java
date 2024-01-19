package com.tcs.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public List<String> myMails()
	{
		return Arrays.asList("smith@gmail.com","ram@yahoo.com","koti@outlook.com","sam@tcs.com");
		
	}

}
