/**
 * 
 */
package com.review.Review.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * Que es Serializable?
 * 
 * Permite convertir cualquier objeto cuya clase implemente el interface
 * Serializable en una secuencia de bytes que pueden ser posteriormente leídos
 * para restaurar el objeto original.
 * 
 * 
 * @author Alan
 *
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequestTO implements Serializable {

	/**
	 * uuid serializable
	 */
	private static final long serialVersionUID = 701102522063690917L;

	/**
	 * Usuario de request
	 */
	@NotNull
	@Size(min = 3, max = 15, message = "El tamaño debe ser minimo de 3 y maximo de 15")
	private String user;

	/**
	 * pass de usuario de request
	 */
	@NotNull
	@Size(min = 1, max = 200, message = "El tamaño debe ser minimo de 1 y maximo de 200")
	private String pass;

}
