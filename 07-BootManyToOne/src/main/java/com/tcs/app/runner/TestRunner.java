package com.tcs.app.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tcs.app.entities.LoanEntity;
import com.tcs.app.repositories.LoanRepository;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class TestRunner implements ApplicationRunner {

	@Autowired
	LoanRepository loanRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		/*
		 * create customer instance
		 */
		//CustomerEntity customer=new CustomerEntity(1011,"tharun");
		
		/*
		 * create loan instance
		 */
		/*
		 * LoanEntity loan1=new LoanEntity(100,"House",50000.00, customer); LoanEntity
		 * loan2=new LoanEntity(101,"Finance",40000.00, customer); LoanEntity loan3=new
		 * LoanEntity(102,"TV",70000.00, customer);
		 * 
		 * loanRepo.save(loan1); loanRepo.save(loan2); loanRepo.save(loan3);
		 */
		
		Optional<LoanEntity> opt=loanRepo.findById(101);
		opt.ifPresent(System.out::println);
	}

}
