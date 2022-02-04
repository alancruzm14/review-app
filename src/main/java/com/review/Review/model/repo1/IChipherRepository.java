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
public interface IChipherRepository extends MongoRepository<KeysCipherDocument, String> {

	/**
	 * Metodo de busqueda
	 */
	KeysCipherDocument findByIdKey(String idKey);

}
