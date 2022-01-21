package com.review.Review.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.review.Review.component.AuxComponent;
import com.review.Review.dto.LoginRequestTO;
import com.review.Review.dto.RegisterRequestTO;
import com.review.Review.exceptions.ReviewException;
import com.review.Review.model.UserDocument;
import com.review.Review.repository.IUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginService implements ILoginService {

	/**
	 * Repositorio para guardar en BD
	 */
	@Autowired
	private IUserRepository iUserRepository;

	/**
	 * Service Aes para cifrar y descifrar
	 */
	@Autowired
	private IAesService iAesService;

	/**
	 * Componente de utilidad
	 */
	@Autowired
	private AuxComponent auxComponent;

	/**
	 * Metodo para auth al usuario
	 * 
	 * @throws ReviewException
	 */
	@Override
	public boolean authUser(LoginRequestTO loginDto) throws ReviewException {
		log.info("Inicia auth: {}", auxComponent.getJsonByObj(loginDto));

		UserDocument userDoc = iUserRepository.findByUser(loginDto.getUser());
		if (userDoc != null) {
			log.info("Usuario Existente");
			if (userDoc.getPass().equals(loginDto.getPass())) {
				log.info("::: Auth Exitosa :::");
			} else {
				log.info("Auth Incorrecta");
			}

		} else {
			throw new ReviewException("001", "Usuario Inexistente", HttpStatus.NOT_FOUND);
		}

		return true;
	}

	/**
	 * 
	 * @param registerRequestTO
	 * @return
	 */
	@Override
	public boolean createUser(RegisterRequestTO registerRequestTO) throws ReviewException {
		log.info("Inicia registro: {}", auxComponent.getJsonByObj(registerRequestTO));

		String pass = iAesService.getAES(registerRequestTO.getPass());
		log.info("Contra cifrada: {}", pass);

		UserDocument usDoc = new UserDocument(registerRequestTO.getUser(), pass, registerRequestTO.getMail(),
				LocalDateTime.now());
		log.info("Bean user: {}", auxComponent.getJsonByObj(usDoc));

		iUserRepository.save(usDoc);

		return true;
	}

}
