/**
 * 
 */
package com.review.Review.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.review.Review.model.KeysCipherDocument;

/**
 * @author macbook
 *
 */
@Repository()
public interface IChipherRepository extends MongoRepository<KeysCipherDocument, String> {

	/**
	 * Metodo de busqueda
	 */
	KeysCipherDocument findByIdKey(String idKey);

}
