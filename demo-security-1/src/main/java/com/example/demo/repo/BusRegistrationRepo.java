package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BusRegistrationEntity;

@Repository
public interface BusRegistrationRepo extends JpaRepository<BusRegistrationEntity, Long>  {

	List<BusRegistrationEntity> findByBusOwner(String busOwner);
	Optional<BusRegistrationEntity> findByLogin(String login);

}
