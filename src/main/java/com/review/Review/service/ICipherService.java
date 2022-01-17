/**
 * 
 */
package com.review.Review.service;

import com.review.Review.dto.KeysCipherTO;

/**
 * @author Alan
 *
 */
public interface ICipherService {

	/**
	 * Metodo para obtener llave publica
	 * 
	 * @return
	 */
	public KeysCipherTO getPublicKey();

	/**
	 * Metodo para descifrar en base al id del key
	 * 
	 * @param cipherText
	 * @return
	 */
	public String getEncriptText(String idKey, String textPlain);

	/**
	 * Metodo para descifrar en base al id del key
	 * 
	 * @param cipherText
	 * @return
	 */
	public String getDecriptText(String idKey, String encryptedText);

}
