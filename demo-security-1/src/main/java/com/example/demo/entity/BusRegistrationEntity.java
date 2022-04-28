package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.context.annotation.Primary;

import lombok.Data;

@Entity

@Table(name = "bus_master" , 
	 //  schema = "employee",
	   uniqueConstraints=
       @UniqueConstraint(columnNames={"bus_login", "password"}))
@Data
public class BusRegistrationEntity {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	Long id;
	
	@Column(name="bus_owner")
	private String busOwner;
	 
	@Column(name="bus_name")
	private String busName;
	
	@Column(name="bus_number")
	private String busNumber;
	
	@Column(name="bus_login",unique = true)
	private String login;
	
	@Column(name="password")
	private String password;
	
	

}
