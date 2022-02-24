/**
 * 
 */
package com.review.Review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.review.Review.service.RestService;

/**
 * @author macbook
 *
 */
@RestController
@RequestMapping("/api/v1/rest")
public class RestFunctionController {

	@Autowired
	private RestService restService;

	@GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> testRest() {

		restService.testRest();

		return new ResponseEntity<>("Its Ok", HttpStatus.OK);
	}

}
