package com.example.demo;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class DemoSecurityApplication {

	@Autowired
	DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		 JdbcTemplate template=new JdbcTemplate();
		 template.setDataSource(dataSource);
		return template;
	}
	

	

}
