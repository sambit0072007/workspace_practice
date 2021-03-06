package com.example.demo.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.model.BusUser;
import com.example.demo.service.MyUserDetailsService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyCustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	MyUserDetailsService userDetailsService;
	@Autowired
	PasswordEncoder encoder;
	
	
	
	
	
	public MyCustomAuthenticationProvider() {
		super();
	}


	public MyCustomAuthenticationProvider(MyUserDetailsService userDetailsService, PasswordEncoder encoder) {
		super();
		this.userDetailsService = userDetailsService;
		this.encoder = encoder;
	}


	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UserDetails user=userDetailsService.loadUserByUsername(authentication.getName());
		log.info("Inside the Provider and fetching credentials from DB  and bean respectively  {}, {} ", authentication.getCredentials().toString(),user.getPassword() );
		Authentication auth=null;
		
		log.info("Testing Encoder function:: {} ",encoder.matches(authentication.getCredentials().toString(), user.getPassword()) );
		if(encoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
			 auth= new MyLoginPasswordBasicToken(user.getUsername(), user.getPassword(),new ArrayList<>());
			// auth.setAuthenticated(true);

		        SecurityContextHolder.getContext().setAuthentication(auth);// Without this after authentication it would throw 403 Forbidden
			 log.info("auth returned in the Basic Token action:: {}", auth);
		}
		else {
			log.info("Bad credentials provided.");
			throw new BadCredentialsException("Bad Credentials");
		}
		return auth;
	}
	 

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return MyLoginPasswordBasicToken.class.equals(authentication);
	}

}
