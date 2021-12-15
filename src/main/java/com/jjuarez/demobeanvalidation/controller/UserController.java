package com.jjuarez.demobeanvalidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jjuarez.demobeanvalidation.entity.User;
import com.jjuarez.demobeanvalidation.service.UserService;

@RestController
public class UserController {
	
	@Autowired UserService userService;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
}
