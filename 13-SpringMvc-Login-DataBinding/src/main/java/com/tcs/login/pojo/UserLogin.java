package com.tcs.login.pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserLogin {
	@NotEmpty
	@Size(min=5)
	private String userName;
	
	@NotEmpty
	@Pattern(regexp = "^[A-Z][a-z0-9]{7}")
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
