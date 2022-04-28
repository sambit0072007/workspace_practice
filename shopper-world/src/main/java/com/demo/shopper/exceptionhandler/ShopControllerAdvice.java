package com.demo.shopper.exceptionhandler;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice extends ResponseEntityExceptionHandler {
	
	Map<String, Object> messageMap= new HashMap();
	SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM-yyyy hh:MM:ss");
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,Object>> myExceptionHandler(Exception e)
	{
		messageMap.clear();
		messageMap.put("Error Message", "Some error/exception occurred. Kindly Check");
		messageMap.put("Date",sdf.format(System.currentTimeMillis()));
		messageMap.put("Issuer","Shopper World");
		return new ResponseEntity<Map<String,Object>>(messageMap, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HandlerNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handlerNotFoundException(HandlerNotFoundException e)
	{
		messageMap.clear();
		messageMap.put("Error Message", "Some error/exception occurred. Kindly Check");
		messageMap.put("Date",sdf.format(System.currentTimeMillis()));
		messageMap.put("Issuer","Shopper World");
		return new ResponseEntity<Map<String,Object>>(messageMap, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<Map<String,Object>> duplicateKeyException(DuplicateKeyException e)
	{
		messageMap.clear();
		messageMap.put("Error Message", "Duplicate Values insert attempted. Kindly Check");
		messageMap.put("Date",sdf.format(System.currentTimeMillis()));
		messageMap.put("Issuer","Shopper World");
		messageMap.put("status", StatusCode.DUPLICATE_INSERT.getStatusCode() +" - "+StatusCode.DUPLICATE_INSERT.getStatusMessage());
		return new ResponseEntity<Map<String,Object>>(messageMap, HttpStatus.BAD_REQUEST);
	}
	
//
//	@Override
//	@ExceptionHandler(NoHandlerFoundException.class)
//	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
//			HttpStatus status, WebRequest request) {
//		// TODO Auto-generated method stub
//		return super.handleNoHandlerFoundException(ex, headers, status, request);
//	}

}
