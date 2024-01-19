package com.tcs.example.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleComponent implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Hello World");

	}

}
