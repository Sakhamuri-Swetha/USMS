package com.orderManagement.DTO;

import javax.validation.constraints.NotEmpty;

public class LoginDTO {

	@NotEmpty(message="Please enter User ID")
	String email;
	@NotEmpty(message="Please enter password")
	String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
