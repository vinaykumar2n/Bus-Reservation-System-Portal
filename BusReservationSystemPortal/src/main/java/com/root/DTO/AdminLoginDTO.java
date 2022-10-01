package com.root.DTO;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AdminLoginDTO {

	@NotNull(message = "Mobile number should not be null")
	private String mobileNumber;
	
	@NotNull(message="password should not be null")
	private String adminPassword;
}
