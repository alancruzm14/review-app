package com.review.Review.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoMultiConfig {

	@Primary
	@Bean(name = "newdb1Properties")
	@ConfigurationProperties(prefix = "spring.data.mongodb.localdb")
	public MongoProperties getNewDb1Props() throws Exception {
		return new MongoProperties();
	}

	@Primary
	@Bean(name = "mongoTemplate")
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(newdb1MongoDatabaseFactory(getNewDb1Props()));
	}

	@Primary
	@Bean
	public MongoDatabaseFactory newdb1MongoDatabaseFactory(MongoProperties mongo) throws Exception {
		return new SimpleMongoClientDatabaseFactory(mongo.getUri());
	}

	// Segunda config de base Kuestions

	@Bean(name = "newdb2Properties")
	@ConfigurationProperties(prefix = "spring.data.mongodb.kuestionsdb")
	public MongoProperties getNewDb2Props() throws Exception {
		return new MongoProperties();
	}

	@Bean(name = "mongoTemplateKuestions")
	public MongoTemplate newdb2MongoTemplate() throws Exception {
		return new MongoTemplate(newdb2MongoDatabaseFactory(getNewDb2Props()));
	}

	@Bean
	public MongoDatabaseFactory newdb2MongoDatabaseFactory(MongoProperties mongo) throws Exception {
		return new SimpleMongoClientDatabaseFactory(mongo.getUri());
	}

}
