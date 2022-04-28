package com.example.demo.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.NonNull;

@Data
@Validated
public class InputModel {

	@NotBlank(message = " Name cannot be blank")
	private String name;
	@NotEmpty
	private String address;
	
	
}
