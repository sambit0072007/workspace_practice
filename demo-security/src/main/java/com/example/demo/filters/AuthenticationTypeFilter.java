package com.example.demo.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.authentication.MyUserNamePasswordToken;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
//@Order(1)
public class AuthenticationTypeFilter extends OncePerRequestFilter {

	@Autowired
	
	private AuthenticationManager authManager;
	
	//@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		// TODO Auto-generated method stub
		log.info(" Is Skipping AuthenticationTypeFilter as shouldNotFilter:: {} {} ",request.getServletPath(), !(request.getServletPath().equalsIgnoreCase("/api/opengateway")));
		return !(request.getServletPath().equalsIgnoreCase("/api/opengateway"));
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("Incoming Request Filter:: {}",request.getServletPath());
		
		String username= request.getHeader("Username");// request.getHeader("Username");
		String password= request.getHeader("Password");
		log.info("Incoming Request Filter:: {}  , {} ",username, password);
		Authentication auth=new MyUserNamePasswordToken(username, password);
		System.out.println("auth from MyUserNamePasswordToken:: "+auth);
		auth=authManager.authenticate(auth);
		SecurityContextHolder.getContext().setAuthentication(auth);
		filterChain.doFilter(request, response);
		
	}

}
