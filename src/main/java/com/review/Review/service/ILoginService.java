/**
 * 
 */
package com.review.Review.service;

import com.review.Review.dto.LoginRequestTO;
import com.review.Review.dto.RegisterRequestTO;
import com.review.Review.exceptions.ReviewException;

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
	public boolean authUser(LoginRequestTO loginDto) throws ReviewException;

	/**
	 * Metodo de registro del usuario
	 * 
	 * @param registerRequestTO
	 * @return
	 * @throws ReviewException
	 */
	public boolean createUser(RegisterRequestTO registerRequestTO) throws ReviewException;

}
