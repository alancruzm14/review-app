package com.review.Review.controller;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.review.Review.dto.LoginRequestTO;
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
	ILoginService iLoginService;

	@GetMapping(path = "/test", produces = "text/plain")
	public String getTest() {
		return "Test";
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@PostMapping(path = "/login", produces = "application/json")
	public String authUser(@Valid @RequestBody LoginRequestTO loginReq) {

		iLoginService.authUser(loginReq);

		return "OK";
	}

}
