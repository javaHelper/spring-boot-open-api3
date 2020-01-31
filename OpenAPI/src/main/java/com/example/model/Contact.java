package com.example.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document
public class Contact implements Serializable {

	private static final long serialVersionUID = 4048798961366546485L;

	@Schema(description = "Unique identifier of the Contact.", example = "1", required = true)
	private Long id;

	@Schema(description = "Name of the contact.", example = "Jessica Abigail", required = true)
	@NotBlank
	@Size(max = 100)
	private String name;

	@Schema(description = "Phone number of the contact.", example = "62482211", required = false)
	@Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number")
	@Size(max = 25)
	private String phone;

	@Schema(description = "Email address of the contact.", example = "jessica@ngilang.com", required = false)
	@Email(message = "Email Address")
	@Size(max = 100)
	private String email;

	@Schema(description = "Address line 1 of the contact.", example = "888 Constantine Ave, #54", required = false)
	@Size(max = 50)
	private String address1;

	@Schema(description = "Address line 2 of the contact.", example = "San Angeles", required = false)
	@Size(max = 50)
	private String address2;

	@Schema(description = "Address line 3 of the contact.", example = "Florida", required = false)
	@Size(max = 50)
	private String address3;

	@Schema(description = "Postal code of the contact.", example = "32106", required = false)
	@Size(max = 20)
	private String postalCode;

	@Schema(description = "Notes about the contact.", example = "Meet her at Spring Boot Conference", required = false)
	private String note;
}