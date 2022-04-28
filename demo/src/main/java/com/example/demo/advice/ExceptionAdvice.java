package com.example.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Object> myExceptionHandler(final ValidationException ve){
		return  new ResponseEntity<Object>(ve.showException(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NosuchStudentException.class)
	public ResponseEntity<Object> myExceptionHandler(final NosuchStudentException nse){
		return  new ResponseEntity<Object>(nse.showException(),HttpStatus.NO_CONTENT);
	}
}
