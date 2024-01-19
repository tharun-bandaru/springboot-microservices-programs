package com.tcs.app.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tcs.app.entities.PassportEntiy;
import com.tcs.app.entities.PersonEntity;
import com.tcs.app.repositories.PersonRepository;

@Component
public class TestRunner implements ApplicationRunner {

	
	@Autowired
	PersonRepository personRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		/*
		 * create passport instance
		 */
		PassportEntiy passport=new PassportEntiy();
		passport.setPassportNo(211091);
		passport.setExpdate(LocalDate.of(2023, 8, 29));
		
		PersonEntity p=new PersonEntity();
		p.setPid(101);
		p.setPname("ABC");
		p.setP(passport);
		
		personRepo.save(p);
		
	
	}

}
