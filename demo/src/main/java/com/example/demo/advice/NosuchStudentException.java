package com.example.demo.advice;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NosuchStudentException extends Exception{
	String errors;
	String reason;
public String showException() {
	return "Check your search:: "+this.getErrors(); 
}
	
}
