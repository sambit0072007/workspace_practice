package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BusRegistrationEntity;
import com.example.demo.model.BusUserDetails;
import com.example.demo.repo.BusRegistrationRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	BusRegistrationRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.info("User being found :: {} ",username);
		Optional<BusRegistrationEntity> user=   repo.findByLogin(username);
		
		
		if( user.get()==null) {
			throw new UsernameNotFoundException("User not found.");
		}
		System.out.println("User found :: "+user);
		return new BusUserDetails(user.get());
	}

}
