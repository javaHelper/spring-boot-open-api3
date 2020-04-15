package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Office;
import com.example.service.OfficeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "office", description = "the Offices API")
public class OfficeController {

	@Autowired
	private OfficeService officeService;

	@Operation(summary = "Find Offices", description = "Find Offices", tags = { "office" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", 
					content = @Content(array = @ArraySchema(schema = @Schema(implementation = Office.class)))) })
	@GetMapping(value = "/Office", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Office>> findAll() {
		List<Office> offices = officeService.findAll();
		return new ResponseEntity<>(offices, HttpStatus.OK);
	}
	
	
	@Operation(summary = "Find Office by Office Code", description = "Returns a single office", tags = { "office" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = Office.class))),
        @ApiResponse(responseCode = "404", description = "Contact not found") })
    @GetMapping(value = "/contacts/{officeCode}", produces = { "application/json", "application/xml" })
    public ResponseEntity<Office> findContactById(
            @Parameter(description="Id of the Office to be obtained. Cannot be empty.", required=true)
            @PathVariable("officeCode") String officeCode) {

		Office office = officeService.findByOfficeCode(Long.valueOf(officeCode));
		return new ResponseEntity<>(office, HttpStatus.OK);
    }
	
	
	@Operation(summary = "Find Offices By Pages", description = "Find Offices By Pages", tags = { "office" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", 
					content = @Content(array = @ArraySchema(schema = @Schema(implementation = Office.class)))) })
	@GetMapping(value = "/Office/pages", produces = { "application/json", "application/xml" })
	public ResponseEntity<Page<Office>> findAllByPages(
			@Parameter(description="Page number, default is 1") @RequestParam(value="page", defaultValue="1") int pageNumber,
            @Parameter(description="Page size") @RequestParam(value="size", defaultValue="5") int pageSize) {
		
		Page<Office> offices = officeService.findAll(PageRequest.of(pageNumber, pageSize));
		return new ResponseEntity<>(offices, HttpStatus.OK);
	}
}
