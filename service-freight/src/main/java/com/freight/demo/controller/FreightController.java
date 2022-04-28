package com.freight.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/freight")
public class FreightController {
	
	@Autowired
	RestTemplate template;
	
	@GetMapping
	public String freightWareHouse() {
		
		return "Welcome to freight warehouse.";
	}

	@GetMapping("/checkTruck/{operator}")
	public String checkYourTruck(@PathVariable String operator) {
		System.out.println("Inside Freight warehouse .....................");
//		String responseFromFreight=template.getForObject("http://SERVICE-TRUCK/truck/leased/"+operator, String.class);
	//	String responseFromFreight=template.getForObject("http://SERVICE-GATEWAY/service-truck/truck/leased/"+operator, String.class);// This will be used when no path is mentioned in the properties file
		String responseFromFreight=template.getForObject("http://SERVICE-GATEWAY/truck-api/truck/leased/"+operator, String.class);
		return "Here are the trucks for your freight.  "+responseFromFreight  ;
	}
}
