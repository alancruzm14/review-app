/**
 * 
 */
package com.review.Review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.Review.repository.RestServiceRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author macbook
 *
 */
@Service
@Slf4j
public class RestService {

	@Autowired
	private RestServiceRepository restServiceRepository;
	
	public void testRest() {
		
		restServiceRepository.getInfoById("1");
		
	}
	
}
