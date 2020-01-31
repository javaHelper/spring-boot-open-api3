package com.example.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.model.Contact;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Annotation Developed to add header Values for all Country APIs
 * @author e081155
 */
@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Parameter(in = ParameterIn.HEADER, description = "Pass X-Accept-Version", name = HeaderConst.X_ACCEPT_VERSION, 
		content = @Content(schema = @Schema(type = "string", defaultValue = HeaderConst.V1, 
		allowableValues = {HeaderConst.V1}, implementation = Contact.class)))
public @interface ApiCountryHeader {

}
