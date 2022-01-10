/**
 * 
 */
package com.review.Review.service;

import com.review.Review.dto.LoginRequestTO;

/**
 * @author Alan
 *
 */
public interface ILoginService {

	/**
	 * Metodo de auth
	 * 
	 * @param loginDto
	 * @return
	 */
	public boolean authUser(LoginRequestTO loginDto);

}
