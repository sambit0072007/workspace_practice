package com.demo.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition (info = @Info(title=" TVK Store "))
public class StoreInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreInventoryApplication.class, args);
	}

}
