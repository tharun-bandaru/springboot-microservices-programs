package com.tcs.example.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoComponent implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Welcome Boot!!!");
	}



}