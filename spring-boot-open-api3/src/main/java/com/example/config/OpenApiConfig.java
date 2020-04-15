package com.example.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {	
		Contact contact = new Contact().name("Offices API").url("https://www.offices-api.com").email("sales@offices.com");
		
		return new OpenAPI().components(new Components()).info(
				new Info().title("Offices Application API")
				.description("This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3.")
				.version("1.0.0")
				.license(new License().name("Offices Application API Licesed").url("https://www.offices-api.com"))
				.contact(contact));
	}
}