package com.truck.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/truck")
public class TruckController {
	
	@Autowired
	RestTemplate template;
	
	
	
	@GetMapping
	public String welcomeTruck() {
//		String responseFromFreight=template.getForObject("http://SERVICE-FREIGHT/freight", String.class);
		System.out.println("Inside Welcome Truck......................");
		//String responseFromFreight=template.getForObject("http://SERVICE-GATEWAY/freight-api/freight/", String.class);// With Zuul
		String responseFromFreight=template.getForObject("http://SERVICE-GATEWAY/freight/", String.class);// with spring cloud
		return "Welcome to ABC Truck Services Pvt. Ltd.  "+responseFromFreight  ;
	}
	
	@GetMapping("/leased/{operator}")
	public String leasedTruck(@PathVariable String operator) {
		//String responseFromFreight=template.getForObject("http://SERVICE-FREIGHT/freight/checkTruck/Srivalli Truck Services", String.class);
		return  "The consignment will be made by "+operator ;
	}

}
