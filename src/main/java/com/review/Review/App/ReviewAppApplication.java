package com.review.Review.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.review.*")
@EnableMongoRepositories(basePackages = "com.review.*")
public class ReviewAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewAppApplication.class, args);
	}

}
