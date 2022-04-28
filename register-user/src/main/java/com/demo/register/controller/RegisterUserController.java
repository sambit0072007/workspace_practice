package com.demo.register.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterUserController {
	
	@GetMapping
	public String userRegistrationHome() {
		return "Welcome to User Registration Page";
	}

}
