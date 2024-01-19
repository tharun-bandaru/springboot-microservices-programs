

package com.tcs.login.controller;

import org.springframework.stereotype.Controller; import
org.springframework.web.bind.annotation.GetMapping; import
org.springframework.web.bind.annotation.PostMapping; import
org.springframework.web.bind.annotation.RequestParam;

@Controller public class LoginController {

	@GetMapping(value="/login") public String getLoginPage() { return "Login"; }

	@PostMapping(value="/auth") public String checkLogin(@RequestParam String
			username,@RequestParam String password)
	{ 
		if(username.equals("tharun") &&		password.equals("tcs@123"))
		{
			return "Success"; } 
		else { return "Failure"; }

	}

}
