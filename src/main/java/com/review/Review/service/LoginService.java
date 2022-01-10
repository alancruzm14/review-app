package com.review.Review.service;

import org.springframework.stereotype.Service;

import com.review.Review.dto.LoginRequestTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginService implements ILoginService {

	public boolean authUser(LoginRequestTO loginDto) {
		log.info("Inicia auth: {}", loginDto.toString());

		return true;
	}

}
