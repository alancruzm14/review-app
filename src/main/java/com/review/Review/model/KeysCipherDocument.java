/**
 * 
 */
package com.review.Review.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alan
 *
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeysCipherDocument implements Serializable {

	/**
	 * id generado
	 */
	private static final long serialVersionUID = 6014296696759121693L;

	/**
	 * Propiedad de id de mongo
	 */
	private String id;

	/**
	 * Propiedad de id para los keys
	 */
	private String idKey;

	/**
	 * Propiedad para obtener la llave publica
	 */
	private String publicKey;

	/**
	 * Propiedad para obtener la llave privada
	 */
	private String privateKey;

	/**
	 * Propiedad para obtener fecha de registro de la llave
	 */
	private LocalDateTime dateRegister;

}
