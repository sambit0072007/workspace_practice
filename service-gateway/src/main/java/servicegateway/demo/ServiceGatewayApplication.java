package servicegateway.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import servicegateway.demo.zuulfilters.ErrorFilter;
import servicegateway.demo.zuulfilters.PostFilter;
import servicegateway.demo.zuulfilters.PreFilter;
import servicegateway.demo.zuulfilters.RouteFilter;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableZuulProxy
@EnableAutoConfiguration
public class ServiceGatewayApplication {

	public static void main(String[] args) {
		System.out.println("Inside ZUUL GATEWAY-SERVICE");
		SpringApplication.run(ServiceGatewayApplication.class, args);
	}

//	//@Bean
//	public PreFilter preFilter() {
//		return new PreFilter();
//	}
//
////	@Bean
//	public PostFilter postFilter() {
//		return new PostFilter();
//	}
//
//	//@Bean
//	public ErrorFilter errorFilter() {
//		return new ErrorFilter();
//	}
//
//	//@Bean
//	public RouteFilter routeFilter() {
//		return new RouteFilter();
//	}

}
