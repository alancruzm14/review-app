package com.review.Review.component;

import java.util.Base64;

import org.springframework.stereotype.Component;

/**
 * Componente de conversion de datos
 * 
 * @author Alan
 *
 */
@Component
public class AuxComponent {

	/**
	 * Metodo de conversion de bytes a String
	 * 
	 * @param byteObj
	 * @return
	 */
	public String getStringByBytes(byte[] byteObj) {
		return Base64.getEncoder().encodeToString(byteObj);
	}

}
