package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.InputModel;
import com.example.demo.model.OutputModel;
import com.example.demo.model.StudentModel;

@Service
public interface DataService {

	public ResponseEntity<OutputModel> createResponse(InputModel model);
	public ResponseEntity<StudentModel> saveData(StudentModel model);
}
