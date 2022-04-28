package com.demo.practice.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StoreOperationsFilter implements Filter {

	@Value("${allow.store}")
	private boolean allowParameter;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("Inside StoreOperationsFilter>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Date date= new Date(System.currentTimeMillis());
		log.info(" Today Day Number is {}",date.getDay());
		log.info(" Allow Parameter :: {}",allowParameter);
		
		if(!allowParameter) {
			response.getWriter().write("The store is closed. Contact the store again or call toll free number 2333 334 5674");
		}
		else {
			chain.doFilter(request, response);
		}
	}

}
