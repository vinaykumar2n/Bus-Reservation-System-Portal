package com.root.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@NotNull(message = "Name cannot be null!")
	@NotBlank(message = "Name connot be blank!")
	private String firstName;
	
	private String lastName;
	
	@NotNull(message="Password cannot be null!")
	@NotBlank(message= "Password cannot be blank!")
	@Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters in length and can include alphanumerics and special characters")
	private String password;
	
	
	@NotNull(message="Mobile number cannot be null!")
	@NotBlank(message= "Mobile number cannot be blank!")
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
	@Size(min = 10, max = 10)
	private String mobileNumber;
	
	@Email
	private String email;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Reservation> reservations =new ArrayList<>();
	


	
}