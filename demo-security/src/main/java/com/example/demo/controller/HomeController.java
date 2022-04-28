package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentInfoModel;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping
	public String landing() {
		return "Landing page";
	}
	
	@GetMapping("/welcome")
	public String showWelcome() {
		return "welcome to the security demo";
	}
	@GetMapping("/api/opengateway")
	public String openGateway() {
		return "welcome to the Open Gateway";
	}
	
	
	@GetMapping("/welcome/showItems")
	public String showItems() {
		return "welcome to the security demo"+jdbcTemplate.toString();
	}
	
	@PostMapping("/welcome/saveStudents")
	public String saveStudents(@RequestBody StudentInfoModel studentInfoModel) {
		System.out.println(studentInfoModel);
		return "welcome to the security demo"+studentInfoModel.toString();
	}

}
