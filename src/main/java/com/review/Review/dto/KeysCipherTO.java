/**
 * 
 */
package com.review.Review.dto;

import java.io.Serializable;

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
public class KeysCipherTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1155426748167817793L;

	/**
	 * Propiedad de id para los keys
	 */
	private String idKey;

	/**
	 * Propiedad para obtener la llave publica
	 */
	private String publicKey;

}
