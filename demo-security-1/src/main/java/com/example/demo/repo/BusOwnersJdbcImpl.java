package com.example.demo.repo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NewBus;

@Repository
public class BusOwnersJdbcImpl implements BusOwnersJdbcRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> findAllBusOwners() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForList("select * from bus_master");
	}

}
