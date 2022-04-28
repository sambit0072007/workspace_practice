package com.example.demo.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

public class MyBasicAuthenticatonFilter extends BasicAuthenticationFilter {

	@Autowired
	AuthenticationManager authManager;
	
	
	public MyBasicAuthenticatonFilter(AuthenticationManager authenticationManager,
			AuthenticationEntryPoint authenticationEntryPoint) {
		super(authenticationManager, authenticationEntryPoint);
		//authenticationManager.authenticate(authentication)
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		super.doFilterInternal(request, response, chain);
	}

	@Override
	protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			Authentication authResult) throws IOException {
		// TODO Auto-generated method stub
		super.onSuccessfulAuthentication(request, response, authResult);
	}

	@Override
	protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException {
		// TODO Auto-generated method stub
		super.onUnsuccessfulAuthentication(request, response, failed);
	}

	@Override
	protected AuthenticationEntryPoint getAuthenticationEntryPoint() {
		// TODO Auto-generated method stub
		return super.getAuthenticationEntryPoint();
	}

}
