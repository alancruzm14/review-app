package com.review.Review.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.review.Review.*")
public class ReviewAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewAppApplication.class, args);
	}

}
