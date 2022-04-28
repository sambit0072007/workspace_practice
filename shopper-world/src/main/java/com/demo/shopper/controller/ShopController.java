package com.demo.shopper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shopper.model.PurchaseModel;
import com.demo.shopper.service.PurchaseService;

@RestController
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	PurchaseService service;
	
	@GetMapping
	public String welcome() {
		return "Welcome to Shopper World";
	}

	@GetMapping("/{option}")
	public ResponseEntity<Object> checkException(@PathVariable String option) throws Exception{
		if(option.toLowerCase().contains("e")) {
			throw new Exception();
		}
		
		return new ResponseEntity<Object>("Request processing option as "+option, HttpStatus.OK);
	}
	@PostMapping("/saveShop")
	public ResponseEntity<Object> saveShop(@PathVariable String option) throws Exception{
		return new ResponseEntity<Object>("Request processing option as "+option, HttpStatus.OK);
	}
	
	@PostMapping("/purchase")
	public ResponseEntity<Object> purchaseItem(@RequestBody PurchaseModel purchase) throws Exception{
		return service.createPurchase(purchase);
	}
	
}
