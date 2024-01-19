package com.tcs.procedure.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tcs.procedure.repository.EmpRepository;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class TestRunner implements ApplicationRunner {

	@Autowired
	EmpRepository empRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Map<String, Object> map= empRepo.getData(5);
		System.out.println(map.get("P2").toString());
		System.out.println(map.get("P3").toString());
		
	}

}
