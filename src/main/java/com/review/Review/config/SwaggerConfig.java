/**
 * 
 */
package com.review.Review.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Alan
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

	/**
	 * Handler para cachar la respuesta de la doc de swagger
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	/**
	 * Bean definido para agregar una validacion de los paths a exponer
	 * 
	 * @return
	 */
	@Bean
	public Docket apiDocket() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.review.Review.controller")).paths(PathSelectors.any())
				.build();
	}

	/**
	 * Informacion del Api
	 * 
	 * @return
	 */
	private ApiInfo getApiInfo() {

		return new ApiInfoBuilder().title("Api de Studio y Aprendizaje")
				.description("Api diseñada para aprender y repasar conocimiento de java").version("1.0.0")
				.contact(new Contact("Alan J Cruz Miguel", "http://localhost:8080/", "alancruzm14@gmail.com")).build();
	}
}
