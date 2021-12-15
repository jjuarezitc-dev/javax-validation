package com.jjuarez.demobeanvalidation.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {
	
	@NotNull(message = "Name cannot be null")
	@NotEmpty(message = "Name must not be empty")
	@NotBlank(message = "Name must not be blank")
	private final String name;
	
	@Size(min = 3, max = 10, message = "Lastname must be between 3 and 10 characters")
	private final String lastName;
	
	@Positive(message = "Age must be a positive integer")
	private final int age;
	
	@Past(message = "Birth date must be past")
	private final Date birthDate;
}
