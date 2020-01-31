package com.example.controller1;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Contact;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "contact", description = "the Contact API")
public class ContactController1 {
	
	@Operation(summary = "Find Contacts by name", description = "Name search by %name% format", tags = { "contact" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", 
					content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class)))) })
	@Parameter(in = ParameterIn.HEADER, description = "Custom Header To be Pass", name = "Accept-version"
	, content = @Content(schema = @Schema(type = "string", defaultValue = "v2", allowableValues= {"v2"}, implementation = Contact.class)))
	@GetMapping(value = "/contacts", headers = {"Accept-version=v2"})
	public ResponseEntity<Page<Contact>> findAll(Pageable pageable) {
	    Page<Contact> contactPages = new PageImpl<>(new ArrayList(), pageable, 10);
	    return new ResponseEntity<>(contactPages, HttpStatus.OK);
	}
}
