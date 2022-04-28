package com.demo.practice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {
	
	@GetMapping("/welcome")
	public ResponseEntity<Object> welcome(){
		
		Map<String, String> storeMap= new HashMap<String,String>();
		storeMap.put("Store Name", "Big Bazaar -Food Bazaar");
		storeMap.put("Store ID", "709");
		storeMap.put("Store Location", "Bhubaneswar");
		return new ResponseEntity<Object>(storeMap,HttpStatus.OK);
	}
	@GetMapping("/register")
	public ResponseEntity<Object> register(){
		
		Map<String, String> storeMap= new HashMap<String,String>();
		storeMap.put("Name", "Enter your name");
		storeMap.put("Address", "Enter your Address");
		storeMap.put("Contact", "Provide your Mobile or Email");
		return new ResponseEntity<Object>(storeMap,HttpStatus.OK);
	}

}
