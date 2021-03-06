package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.demo.securityfilter.MySecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	@Lazy
	MyCustomAuthenticationProvider myCustomAuthenticationProvider;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//auth.inMemoryAuthentication().withUser("busadmin").password("busadmin").roles("ADMIN"); //.authorities("READ","WRITE");
		System.out.println("1.......................");
		auth.userDetailsService(userDetailsService);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * http.csrf().disable().antMatcher("/api/registration").authorizeRequests()
		 * .antMatchers("/swagger-ui/**").permitAll()
		 * .anyRequest().authenticated().and().httpBasic();
		 */
		http.addFilterAt(new MySecurityFilter(authenticationManagerBean()), BasicAuthenticationFilter.class)
		.csrf().disable()
		.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
		.antMatchers("/swagger-ui/**","/api/registration").permitAll()
		.anyRequest().authenticated().and().httpBasic();
		
		
	}
	
	@Bean
	@Lazy
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return new ProviderManager(Arrays.asList(myCustomAuthenticationProvider)); 
	}
	
	

}
