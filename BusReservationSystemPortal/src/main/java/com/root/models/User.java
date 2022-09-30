package com.root.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@NotNull(message = "Name should not be null")
	private String firstName;
	
	private String lastName;
	
	@NotNull(message="password should not be null")
	private String password;
	
//	@Pattern(regexp = "[0-9]{10}", message = "Mobile No is Invalid")
	
	@NotNull
	private String mobileNumber;
	
	@Email
	private String email;


	
}