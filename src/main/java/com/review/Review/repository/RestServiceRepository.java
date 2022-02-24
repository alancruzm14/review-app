/**
 * 
 */
package com.review.Review.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author macbook
 *
 */
@Repository
@Slf4j
public class RestServiceRepository {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 
	 * @param id
	 * @return
	 */
	public String getInfoById(String id) {

		String uri = "https://rickandmortyapi.com/api/character/61";
		Object resp = null;

		resp = restTemplate.getForEntity(uri, Object.class);

		System.out.println(resp);

		return "";
	}

}
