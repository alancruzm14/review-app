/**
 * 
 */
package com.review.Review.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * @author macbook
 *
 */
@Getter
@Setter
public class ReviewException extends Exception implements Serializable {

	/**
	 * Id del seriailizer
	 */
	private static final long serialVersionUID = 8868831123274407124L;

	/**
	 * Codigo de error
	 */
	private String codigoError;

	/**
	 * Mensaje de error
	 */
	private String mensajeError;

	/**
	 * Status HTTP
	 */
	private HttpStatus httpStatus;

	public ReviewException(String codigoError, String mensajeError, HttpStatus httpStatus) {
		super();
		this.codigoError = codigoError;
		this.mensajeError = mensajeError;
		this.httpStatus = httpStatus;
	}
}
