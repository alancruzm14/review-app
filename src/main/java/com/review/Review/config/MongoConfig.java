package com.review.Review.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {

	private static final String DATA_BASE = "reviewDb";

	private static final String HOST = "localhost";

	private static final String PORT = "27017";

	/**
	 * Bean de client de mongo para conectarse
	 * 
	 * @return
	 */
	@Bean
	public MongoClient mongo() {
		ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/".concat(DATA_BASE));
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

	/**
	 * Bean de mongo template
	 * 
	 * @return
	 */
	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongo(), DATA_BASE);
	}

}
