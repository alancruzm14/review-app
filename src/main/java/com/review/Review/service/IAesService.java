/**
 * 
 */
package com.review.Review.service;

/**
 * @author macbook
 *
 */
public interface IAesService {

	/**
	 * Metodo para encriptar con Aes 256
	 * 
	 * @param texto
	 * @return
	 */
	public String getAES(String texto);

	/**
	 * Metodo para desencriptar con Aes
	 * 
	 * @param textoCifrado
	 * @return
	 */
	public String getAESDecrypt(String textoCifrado);

}
