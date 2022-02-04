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
@EnableMongoRepositories(value = { "com.review.Review.model.repo1" }, mongoTemplateRef = DbLocalConfig.MONGO_TEMPLATE)
public class DbLocalConfig {

	protected static final String MONGO_TEMPLATE = "mongoTemplate";
}
