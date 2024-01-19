package com.tcs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class RestApi3Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(RestApi3Application.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**");
		//.allowedOrigins("*")
	}
	
	@Bean
	public Docket api()
	{
		ApiInfoBuilder builder=new ApiInfoBuilder();
		builder.title("REST API HOTEL ROOM BOOKING");
		builder.description("Hotel   api through swagger");
		builder.license("http://localhost:2023/index.html");
		builder.version("1.1");
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.tcs.demo"))
				.build()
				.apiInfo(builder.build())
				;
	}
	
	

}
