/**
 * 
 */
package com.review.Review.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

/**
 * @author macbook
 *
 */
@Configuration
public class RestTemplateConfig {

	/**
	 * Bean rest para la creacion de un rest template con timeout en especifico
	 * 
	 * @return
	 */
	@Bean("restTemplate")
	@Scope("singleton")
	public RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		return template;
	}

}
