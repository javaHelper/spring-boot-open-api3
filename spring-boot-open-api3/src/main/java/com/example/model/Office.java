package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="offices")
public class Office {
	@Schema(description = "Unique identifier of the Office.", example = "1", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="officeCode")
	private Long officeCode;

	@Schema(description = "City of the Office.", example = "Achalpur", required = true)
	private String city;

	@Schema(description = "Phone number of the office.", example = "62482211", required = false)
	@Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number")
	private String phone;

	@Column(name="addressLine1")
	@Schema(description = "Address1 of the office.", required = false)
	private String addressLine1;

	@Column(name="addressLine2")
	@Schema(description = "addressLine2 of the office.", required = false)
	private String addressLine2;

	@Schema(description = "state of the office.", required = false)
	private String state;

	@Schema(description = "country of the office.", required = false)
	private String country;

	@Column(name="postalCode")
	@Schema(description = "postalCode of the office.", required = false)
	private String postalCode;

	@Schema(description = "territory of the office.", required = false)
	private String territory;
}
