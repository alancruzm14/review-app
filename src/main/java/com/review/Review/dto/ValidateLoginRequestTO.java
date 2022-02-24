package com.review.Review.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateLoginRequestTO {

	/**
	 * Usuario de request
	 */
	@NotNull
	private String user;

	/**
	 * Usuario de request
	 */
	@NotNull
	private String token;

}
