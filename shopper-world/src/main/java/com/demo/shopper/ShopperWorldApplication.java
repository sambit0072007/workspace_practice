package com.demo.shopper;


import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition (info = @Info(title="Shoppers World"))
public class ShopperWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopperWorldApplication.class, args);
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	DataSource getDataSource() {
		DataSourceBuilder builder= DataSourceBuilder.create();
		//builder.driverClassName("com.mysql.jdbc.Driver");
		builder.url("jdbc:mysql://localhost:3306/springjdbc");
		builder.username("root");
		builder.password("root");
		return builder.build();
	}
	
	
	
	
//	@Bean
//	public Docket postsApi() {
//		return new Docket(DocumentationType.SWAGGER_2).groupName("com.demo")
//				.apiInfo(apiInfo()).select().paths(postPaths()).build();
//	}
//
//	@Bean
//	private Predicate<String> postPaths() {
//		return or(regex("/shop**"), regex("/com/demo/**"));
//	}
//
//	@Bean
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder().title("JavaInUse API")
//				.description("JavaInUse API reference for developers")
//				.termsOfServiceUrl("http://javainuse.com")
//				.contact("sambit0072007@gmail.com").license("JavaInUse License")
//				.licenseUrl("sambit0072007@gmail.com").version("1.0").build();
//	}

}


