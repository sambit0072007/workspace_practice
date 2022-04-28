package com.demo.practice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@GetMapping("/view")
	public ResponseEntity<Object> customer(){
		Map<String, String> customerMap= new HashMap();
		customerMap.put("Customer Name", "Joe Husky");
		customerMap.put("Customer Address", "Hyderabad");
		return new ResponseEntity<Object>(customerMap, HttpStatus.OK);
	}

}
