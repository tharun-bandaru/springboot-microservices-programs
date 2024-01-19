package com.tcs.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.demo.api.security.MyUserDetailsService;
import com.tcs.demo.pojos.AuthenticationRequest;
import com.tcs.demo.pojos.AuthenticationResponse;
import com.tcs.demo.util.JwtUtil;

@RestController
public class TokenAPI {

	@Autowired
	private AuthenticationManager authenticationManger;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@PostMapping(value="/token")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenthenticationRequest) throws Exception
	{
		try {

			authenticationManger.authenticate(new UsernamePasswordAuthenticationToken(authenthenticationRequest.getUsername(), authenthenticationRequest.getPassword()));
		}
		catch(BadCredentialsException ex)
		{
			throw new Exception("Incorrect username or password",ex);
		}

		final UserDetails userDetails=userDetailsService.loadUserByUsername(authenthenticationRequest.getUsername());

		final String jwt= jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
