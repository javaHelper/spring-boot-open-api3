package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.converters.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.ApiCountryHeader;
import com.example.config.HeaderConst;
import com.example.model.Contact;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
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
public class ContactController {

	@Operation(summary = "Find Contacts by name", description = "Name search by %name% format", tags = { "contact" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class)))) })

	@Parameter(in = ParameterIn.QUERY, description = "Zero-based page index (0..N)", name = "page"
	, content = @Content(schema = @Schema(type = "integer", defaultValue = "0")))
	@Parameter(in = ParameterIn.QUERY, description = "The size of the page to be returned", name = "size"
	, content = @Content(schema = @Schema(type = "integer", defaultValue = "20")))
	@Parameter(in = ParameterIn.QUERY, description = "Sorting criteria in the format: property(,asc|desc). "
			+ "Default sort order is ascending. " + "Multiple sort criteria are supported."
			, name = "sort", content = @Content(array = @ArraySchema(schema = @Schema(type = "string"))))
	@Parameter(in = ParameterIn.HEADER, description = "Custom Header To be Pass", name = "Accept-version"
	, content = @Content(schema = @Schema(type = "string", defaultValue = "v1", allowableValues= {"v1"}, implementation = Contact.class)))
	@GetMapping(value = "/contacts", headers = {"Accept-version=v1"})
	public ResponseEntity<List<Contact>> findAll() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ v1");
		List<Contact> contacts = new ArrayList<>();
		contacts.add(Contact.builder().address1("Address1").address2("Address2").build());
		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}


	/*@Operation(summary = "Find Contacts by name", description = "Name search by %name% format", tags = { "contact" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class)))) })
	@Parameters({
		@Parameter(name = "pageNumber", description = "page number",
				in = ParameterIn.QUERY, schema = @Schema(type = "integer")),
		@Parameter(name = "pageSize", description = "page size", 
		in = ParameterIn.QUERY, schema = @Schema(type = "integer")),
		@Parameter(name = "sort", description = "sort specification",
		in = ParameterIn.QUERY, schema = @Schema(type = "string", allowableValues = {"HOME", "OFFICE"})),
		@Parameter(in = ParameterIn.HEADER, name = "Accept-version", 
		schema = @Schema(type = "string", allowableValues = {"v2"}, defaultValue = "v2"))
	})
	@Hidden
	@GetMapping(value = "/contacts", headers = {"Accept-version=v2"})
	public ResponseEntity<List<Contact>> findAll2(@Parameter(hidden = true) Pageable pageable) {
		System.out.println("========================== V2");
		List<Contact> contacts = new ArrayList<>();
		contacts.add(Contact.builder().address1("Address1").address2("Address2").build());
		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}*/
	
	
	
	@Operation(summary = "Find Language Code By Country Code and Numeric Code")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "For Success as well as No Data found scenerio."),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@ApiCountryHeader
	@GetMapping(value = "/countries/language-codes", headers = HeaderConst.X_ACCEPT_VERSION_V1)
	public ResponseEntity<Contact> findCountryLanguages(
			@RequestParam(required = false) String alpha2Cd,
			@RequestParam(required = false) String alpha3Cd,
			@RequestParam(required = false) Integer number3Cd) {
		
		Contact response = new Contact();
		response.setAddress1("Address1");
		response.setAddress2("Address2");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}