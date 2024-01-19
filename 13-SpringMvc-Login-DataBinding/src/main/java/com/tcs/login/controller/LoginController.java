package com.tcs.login.controller;
import javax.validation.Valid;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PostMapping;

import com.tcs.login.pojo.UserLogin;

@Controller
public class LoginController {

	@GetMapping(value="/login") 
	public String getLogin(Model model)
	{ 
		UserLogin userLogin= new UserLogin(); model.addAttribute("userLogin",userLogin); 

		return"Login"; 
	}

	@PostMapping(value="/auth") 
	public String checkLogin(@Valid @ModelAttribute UserLogin userLogin,BindingResult result) 

	{
		System.out.println(result);
		if(result.hasErrors()) 
		{ 
			return "Login"; 
		}
		else {
			if(userLogin.getUserName().equals("Tharun") &&
					userLogin.getPassword().equals("Tharun@1")) 
			{ 
				return "Success"; } 
			else {
				return "Failure"; 
			}
		}
	}
}


