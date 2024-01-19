package com.tcs.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.page.entity.Employee;
import com.tcs.page.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/pagination")
	public String getPage(@RequestParam(value= "pageIndex",defaultValue= "0" ) int pageIndex,Model model) {

		Page<Employee> page=service.fetchDataOfPage(pageIndex);
		model.addAttribute("employees",page.getContent());
		model.addAttribute("currentPage",page.getNumber());
		model.addAttribute("previous", page.hasPrevious());
		model.addAttribute("next", page.hasNext());
		return "display";
	}
}
