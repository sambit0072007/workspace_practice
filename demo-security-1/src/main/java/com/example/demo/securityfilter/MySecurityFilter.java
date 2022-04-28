package com.example.demo.securityfilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.config.MyLoginPasswordBasicToken;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MySecurityFilter extends OncePerRequestFilter {

	// This is  an important step tp register the filter with the Authentication Manager:: Sambit
	public MySecurityFilter(AuthenticationManager authManager) {
		super();
		this.authManager = authManager;
	}

	@Autowired
	AuthenticationManager authManager;
	

	//@Autowired
	//AuthenticationProvider authProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("Inside SecurityFilter - doFilter {}",request.getServletPath() );
//		while(request.getAttributeNames().hasMoreElements()) {
//			log.info(request.getAttributeNames().nextElement());
//		}
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			  String headerName = headerNames.nextElement();
			  System.out.println("Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
			}
	
		log.info("Request details:::::::::::::::::");
		Enumeration<String> paramNames = request.getParameterNames();
		/*
		 * while(paramNames.hasMoreElements()) { String paramName =
		 * paramNames.nextElement(); System.out.println("Header Name - " + paramNames +
		 * ", Value - " + request.getParameter(paramName)); }
		 */
		
		String username= request.getHeader("login");
		String password= request.getHeader("password");
		
		if(username!=null && !username.trim().equalsIgnoreCase("")) {
			//Do another type of Authentication instead of basic auth
			Authentication authUser= new  MyLoginPasswordBasicToken(username, password);
			log.info("Auth User from Token:: "+authUser);
			log.info("AuthenticationManager :: "+authManager);
			authUser=authManager.authenticate(authUser);
			
			
		}
		
		
		
		filterChain.doFilter(request, response);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		// TODO Auto-generated method stub
		//return request.getServletPath().equalsIgnoreCase("/api/registration");
		log.info(" Is the current  API {} is  being authenticated through MyCustomFilter {}",request.getServletPath(), request.getServletPath().equalsIgnoreCase("/api/auth-by-filter"));
		
		return !request.getServletPath().equalsIgnoreCase("/api/auth-by-filter");
	}

}
