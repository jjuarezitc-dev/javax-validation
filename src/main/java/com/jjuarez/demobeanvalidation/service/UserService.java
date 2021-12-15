package com.jjuarez.demobeanvalidation.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import com.jjuarez.demobeanvalidation.entity.User;

@Component
public class UserService {
	
	public User saveUser(User user) {
		this.validateUser(user);
		// Use User object as intended from here...
		// ...
		return new User(user.getName(), user.getLastName(), user.getAge(), user.getBirthDate());
	}
	
	private void validateUser(User user) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		
		if(violations.size() > 0) {
			List<String> violationMessages = violations.stream().map(ConstraintViolation::getMessageTemplate).collect(Collectors.toList());
			throw new IllegalArgumentException("Validation of user failed with results - >> " + violationMessages);
		}
	}
}
