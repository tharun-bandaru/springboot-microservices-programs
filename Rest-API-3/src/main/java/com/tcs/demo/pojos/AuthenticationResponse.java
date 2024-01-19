package com.tcs.demo.pojos;

import java.io.Serializable;
//2
public class AuthenticationResponse implements Serializable {

	private final String jwt;

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}
	
	public String getJwt()
	{
		return this.jwt;
	}
	
	
	
	
}
