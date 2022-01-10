/**
 * 
 */
package com.review.Review.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alan
 *
 */
@Getter
@Setter
@Document(collection = "Users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDocument implements Serializable {

	/**
	 * serial id default
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * usuario del registro del loggeo
	 */
	private String user;
	/**
	 * Contrasena del registro del usuario
	 */
	private String pass;
	/**
	 * Fecha de regsitro
	 */
	private LocalDateTime registerDate;

}
