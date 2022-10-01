package com.root.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@NotNull(message = "Name cannot be null!")
	@NotBlank(message = "Name connot be blank!")
	private String firstName;
	
	private String lastName;

	@NotNull(message="Password cannot be null!")
	@NotBlank(message= "Password cannot be blank!")
	private String adminPassword;
	
	@NotNull(message="Mobile number cannot be null!")
	@NotBlank(message= "Mobile number cannot be blank!")
	@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile No is Invalid")
	@Size(min = 10, max = 10)
	private String mobileNumber;
	
	@Email
	private String email;

	
	
	
	
	
	
}

