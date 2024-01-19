package com.tcs.page.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tcs.page.entity.Employee;
import com.tcs.page.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;
	
	public Page<Employee> fetchDataOfPage(int pageIndex){
		//create pagable instance
		Pageable pageable=PageRequest.of(pageIndex, 4);
		return repo.findAll(pageable);
	}
	
}
