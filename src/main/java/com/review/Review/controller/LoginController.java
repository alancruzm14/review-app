package com.review.Review.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.review.Review.dto.LoginRequestTO;
import com.review.Review.dto.RegisterRequestTO;
import com.review.Review.exceptions.ReviewException;
import com.review.Review.service.ILoginService;

/**
 * Clase del controller de login
 * 
 * @author Alan
 *
 */
@RestController
@RequestMapping("/api/v1")
@Validated
public class LoginController {

	@Autowired
	private ILoginService iLoginService;

	@GetMapping(path = "/test", produces = "text/plain")
	public String getTest() {
		return "Test";
	}

	@PostMapping(path = "/login", produces = "application/json")
	public String authUser(@Valid @RequestBody LoginRequestTO loginReq) throws ReviewException {

		iLoginService.authUser(loginReq);

		return "OK";
	}
	
	@PostMapping(path = "/register", produces = "application/json")
	public String registerUser(@Valid @RequestBody RegisterRequestTO registerRequestTO) throws ReviewException {

		iLoginService.createUser(registerRequestTO);

		return "OK";
	}

}
