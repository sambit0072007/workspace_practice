package com.example.demo.repo;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.NewBus;

@Repository
public interface BusOwnersJdbcRepo {

	public List<Map<String, Object>> findAllBusOwners();
}
