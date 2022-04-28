package com.example.demo.advice;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationException extends Exception{
	List errors;
	String reason;
public String showException() {
	return "VALIDATION:: "+this.getErrors(); 
}
	
}
