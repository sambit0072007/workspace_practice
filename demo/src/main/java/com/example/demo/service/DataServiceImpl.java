package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.InputModel;
import com.example.demo.model.OutputModel;
import com.example.demo.model.StudentModel;

@Service
public class DataServiceImpl implements DataService {

	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
	@Autowired
	OutputModel opModel;
	@Override
	public ResponseEntity<OutputModel> createResponse(InputModel model) {
		// TODO Auto-generated method stub
		opModel.setName(model.getName());
		opModel.setAddress(model.getAddress());
		opModel.setCurrentDate(sdf.format(new Date()));
		return new ResponseEntity<OutputModel>(opModel,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<StudentModel> saveData(StudentModel model) {
		// TODO Auto-generated method stub
		return null;
	}

}
