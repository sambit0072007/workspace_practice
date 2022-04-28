package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BusRegistrationEntity;
import com.example.demo.model.BusUser;
import com.example.demo.model.NewBus;
import com.example.demo.service.BusRegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class BusController {
	@Autowired
	BusRegistrationService service;
	
	@GetMapping
	public String bus() {
		return "Welcome to ABC bus services";
	}

	@ApiResponse(description = "Registration of New Bus")
	@PostMapping("/registration")
	public ResponseEntity<Object> registerNewBus(@RequestBody NewBus newBus) {
		ObjectMapper mapper= new ObjectMapper();
		
		BusRegistrationEntity entity=mapper.convertValue(newBus, BusRegistrationEntity.class);
		log.info("Entity Mapped :: {}",entity);
		
		return service.saveBus(entity);
	}
	
	@GetMapping("/auth-by-filter")
	public ResponseEntity<Object> authByfilter() {
		log.info("Auth By FILTER CUSTOM");
		return new ResponseEntity<Object>("Auth By Filter CUSTOM",HttpStatus.OK);
	}

	
	
	@GetMapping("/findByOwner/{owner_name}")
	public ResponseEntity<Object> findByOwner(@PathVariable("owner_name") String ownerName) {
		log.info("Finding buses for Owwner {}",ownerName);
		return new ResponseEntity<Object>(service.findByOwnerName(ownerName),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody BusUser busUser) {
		ObjectMapper mapper= new ObjectMapper();
		
		BusRegistrationEntity entity=mapper.convertValue(busUser, BusRegistrationEntity.class);
		log.info("Entity Mapped :: {}",entity);
		
		return service.saveBus(entity);
	}
	@GetMapping("/findAllOwners")
	public ResponseEntity<Object> findAllOwners() {
		log.info("Finding All buses for Owwners");
		return new ResponseEntity<Object>(service.findAllBusOwners(),HttpStatus.OK);
	}
	
	
}
