package com.example.demo;

import java.util.Collection;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.demo.authentication.MyAuthenticationProvider;
import com.example.demo.filters.AuthenticationTypeFilter;
import com.mysql.cj.protocol.AuthenticationProvider;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Autowired
	private MyAuthenticationProvider authProvider;

	@Autowired
	@Lazy
	private  AuthenticationTypeFilter authFilter;


	


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(authProvider);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/welcome/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.addFilterAt(authFilter, BasicAuthenticationFilter.class);
		http.addFilterAt(authFilter, BasicAuthenticationFilter.class) 
		    .authorizeRequests()
			//.antMatchers("/welcome/**").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();// This allows using credentials in postman for basic auth
			//.formLogin();
	}
	
	@Override
	@Bean
	
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Bean
	PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	

}
