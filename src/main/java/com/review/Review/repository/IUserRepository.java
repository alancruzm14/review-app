/**
 * 
 */
package com.review.Review.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.review.Review.model.UserDocument;

/**
 * @author macbook
 *
 */
@Repository
public interface IUserRepository extends MongoRepository<UserDocument, String> {

	/**
	 * Busqeuda por usuario
	 * 
	 * @param user
	 * @return
	 */
	UserDocument findByUser(String user);

	/**
	 * Busqeuda por usuario
	 * 
	 * @param user
	 * @return
	 */
	UserDocument findByMail(String mail);
}
