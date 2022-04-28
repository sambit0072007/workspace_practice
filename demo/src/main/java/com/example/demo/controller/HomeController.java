package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.advice.NosuchStudentException;
import com.example.demo.advice.ValidationException;
import com.example.demo.controller.model.Students;
import com.example.demo.model.InputModel;
import com.example.demo.model.OutputModel;
import com.example.demo.service.DataService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	
	
	static List<Students> STUDENTLIST= new ArrayList<Students>();
	static {
		STUDENTLIST.add(new Students("Roy",1,"Michigan"));
		STUDENTLIST.add(new Students("Josh",2,"Otawa"));
		STUDENTLIST.add(new Students("Megan",3,"Birmingham"));
	}
	
	@Autowired
	DataService dataService;
	
	@GetMapping("/start")
	public ResponseEntity<String> welcome() {
		return new ResponseEntity<String>("Welcome to the Application", HttpStatus.OK);
		
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Object> showStudent(@PathVariable("id") int studentId) throws NosuchStudentException {
		return new ResponseEntity<Object> (STUDENTLIST.stream().filter(student->student.getStudentId()==studentId).findFirst().orElseThrow(()->new  NosuchStudentException("Any Student with id "+studentId +"  is not available", "No such Student")),HttpStatus.BAD_REQUEST);
		
	}

	@PostMapping("/data")
	public ResponseEntity<? extends Object> saveData(@RequestBody @Valid InputModel model, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			throw new ValidationException(result.getAllErrors().stream().filter(x->x.toString().contains("default message")).collect(Collectors.toList()),"Invalid Data");
		}
		System.out.println("Model data i/p: "+model);
		return dataService.createResponse(model);
		
	}
	@PostMapping("/save/student")
	public ResponseEntity<? extends Object> saveStudent(@RequestBody @Valid InputModel model, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			throw new ValidationException(result.getAllErrors().stream().filter(x->x.toString().contains("default message")).collect(Collectors.toList()),"Invalid Data");
		}
		System.out.println("Model data i/p: "+model);
		return dataService.createResponse(model);
		
	}
}
