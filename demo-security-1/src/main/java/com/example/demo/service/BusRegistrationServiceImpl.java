package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BusRegistrationEntity;
import com.example.demo.model.NewBus;
import com.example.demo.repo.BusOwnersJdbcRepo;
import com.example.demo.repo.BusRegistrationRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BusRegistrationServiceImpl implements BusRegistrationService {

	@Autowired
	BusRegistrationRepo busRegRepo;
	
	@Autowired
	BusOwnersJdbcRepo jdbcRepo;
	
	@Override
	public ResponseEntity<Object> saveBus(BusRegistrationEntity entity) {
		// TODO Auto-generated method stub
		entity=busRegRepo.save(entity);
		log.info("Bus Saved: {}  ",entity);
		return new ResponseEntity<Object>(entity,HttpStatus.OK);
	}

	@Override
	public List<BusRegistrationEntity> findByOwnerName(String ownerName) {
		// TODO Auto-generated method stub
		return busRegRepo.findByBusOwner(ownerName);
	}

	@Override
	public List<Map<String, Object>> findAllBusOwners() {
		// TODO Auto-generated method stub
		return jdbcRepo.findAllBusOwners();
	}

}
