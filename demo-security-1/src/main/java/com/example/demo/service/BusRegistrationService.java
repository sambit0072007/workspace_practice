package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BusRegistrationEntity;
import com.example.demo.model.NewBus;


public interface BusRegistrationService {
	
	public ResponseEntity<Object> saveBus(BusRegistrationEntity newBus);

	public List<BusRegistrationEntity> findByOwnerName(String ownerName);
	
	/*Using jdbc template*/
	public List<Map<String, Object>>findAllBusOwners();

}
