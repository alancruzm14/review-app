/**
 * 
 */
package com.review.Review.model.repo1;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

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
