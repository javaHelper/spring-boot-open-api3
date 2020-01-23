package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
	@Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .setGroup("v1")
                .packagesToScan("com.example")
                .build();
    }
	
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .setGroup("v2")
                .packagesToScan("com.example")
                .build();
    }
	
	@Bean
	public OpenAPI customOpenAPI() {
		Map<String, Object> extensions = new HashMap<>();
		extensions.put("x-artifactId", "x-abc-app");

		Info info = new Info();
		info.setDescription("Contact in OpenAPI 3.");
		info.setExtensions(extensions);
		info.setLicense(new License().name("Contact API").url("https:test.com"));
		info.setContact(new Contact().name("API Support").url("https:test.com")
				.email("support@test.com"));
		info.setTermsOfService("This is Propritory Services");
		info.setTitle("Contact in OpenAPI 3.");
		info.setVersion("1.0.0");
		
		Components components = new Components();
//		components.addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"));
//		components.addParameters("myHeader1", new Parameter().in("header").schema(new StringSchema()).name("myHeader1"))
//			.addHeaders("myHeader2", new Header().description("myHeader2 header").schema(new StringSchema()));
//		
//		components.addParameters("customHeader",
//				new Parameter().name("Accept-version").in("header").required(true).schema(new Schema<>().$ref("#/components/Schemas/Sample")));
		
		return new OpenAPI().components(new Components()).info(info);
	}
}