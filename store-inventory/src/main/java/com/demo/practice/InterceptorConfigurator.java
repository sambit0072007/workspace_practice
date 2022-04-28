package com.demo.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.demo.practice.interceptor.StoreInterceptorHandler;

@Configuration
public class InterceptorConfigurator extends WebMvcConfigurerAdapter{

	@Autowired
	StoreInterceptorHandler storeInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(storeInterceptor).addPathPatterns("/customer/view/**");
	}
	

}
