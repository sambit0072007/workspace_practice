package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class CloudServiceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServiceGatewayApplication.class, args);
	}
	
	@GetMapping("/gateway")
	public String welcomeGateway() {
		return "Gateway Service is on";
		
	}

}
