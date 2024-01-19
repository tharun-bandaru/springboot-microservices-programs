package com.tcs.app.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tcs.app.dao.EmpDao;

@Component
public class SampleComponent implements ApplicationRunner {

	
	@Autowired
	EmpDao empDao;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("runmethod executed");
		empDao.saveEmployee(6, "vasamth", 7000.33, 105);
		
		System.out.println("===============================");
		
		Map<String,Object> resultMap=empDao.fetchEmployeeById(4);
		System.out.println(resultMap);

	}

}
