/**
 * 
 */
package com.review.Review.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author macbook
 *
 */
@Configuration
@EnableMongoRepositories(value = {
		"com.review.Review.model.repo2" }, mongoTemplateRef = DbKuestionsConfig.MONGO_TEMPLATE)
public class DbKuestionsConfig {

	protected static final String MONGO_TEMPLATE = "mongoTemplateKuestions";
}


