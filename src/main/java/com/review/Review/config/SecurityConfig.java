package com.review.Review.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.util.UrlPathHelper;

/**
 * Clase que contiene lo necesario para configurar y manejar la sesión de
 * usuario en el microservicio
 * 
 * @author rhdtp
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Método para confuguración de seguridad del microservicio
	 *
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui", "/swagger-resources",
//						"/swagger-resources/configuration/security", "/swagger-ui.html", "/webjars/**", "/**/api/v1/**",
//						"/**/api/v2/**").permitAll();

		http.authorizeRequests()
		.antMatchers("/v2/api-docs",
				"/swagger-resources/configuration/ui",
				"/swagger-resources",
				"/swagger-resources/configuration/security",
				"/swagger-ui.html",
				"/webjars/**",
				"/**/api/v1/**")
		.permitAll()
		.anyRequest()
		.authenticated();

		http.cors();

		http.csrf().requireCsrfProtectionMatcher(request -> {

			UrlPathHelper urlPathHelper = new UrlPathHelper();
			AntPathMatcher antPathMatcher = new AntPathMatcher();

			List<String> protectedUrlPatterns = Arrays.asList("/csrf/**");

			String uri = urlPathHelper.getPathWithinApplication(request);
			for (String pattern : protectedUrlPatterns) {
				if (antPathMatcher.match(pattern, uri)) {
					return true;
				}
			}
			return false;

		});

	}

	/**
	 * Definición de recursos disponibles sin autenticación
	 *
	 */
	@Override
	public void configure(WebSecurity web) {
		web.ignoring()
			.antMatchers("/v2/api-docs", 
					"/configuration/ui",
					"/swagger-resources", 
					"/configuration/security",
					"/swagger-ui.html", 
					"/webjars/**");
	}

}