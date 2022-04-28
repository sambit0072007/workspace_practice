package com.example.demo.util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderUtil {

	public String bCryptPasswordGenerator(String textPassword) {
		String bCryptedPassword=null;
		//System.out.println(BCrypt.gensalt(textPassword, 10));
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);
		bCryptedPassword=encoder.encode(textPassword);
		return bCryptedPassword;
	}
	
	public boolean bCryptToPlainTextPassword( String plainPassword,String bcryptedPassword) {
		
		//System.out.println(BCrypt.gensalt(textPassword, 10));
		BCrypt decoder= new BCrypt();
		boolean test=decoder.checkpw(plainPassword, bcryptedPassword);//      decode(bcryptedPassword);
		return test;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptEncoderUtil util= new BCryptEncoderUtil();
		String plainPassword="abc099";
		String encodedPassword=util.bCryptPasswordGenerator(plainPassword);
		System.out.println(encodedPassword);
		System.out.println("Source plain text password matches : "+util.bCryptToPlainTextPassword(plainPassword,encodedPassword));
		
	}

}
