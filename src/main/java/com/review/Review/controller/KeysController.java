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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.review.Review.service.ICipherService;

/**
 * @author Alan
 *
 */
@RestController
@RequestMapping("/api/v1")
public class KeysController {

	@Autowired
	private ICipherService iCipherService;

	@GetMapping(path = "/keys", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getKey() {
		return new ResponseEntity<>(iCipherService.getPublicKey(), HttpStatus.OK);
	}

	/**
	 * Metodo de encripcion de un dato
	 * 
	 * @param word
	 * @param idKey
	 * @return
	 */
	@GetMapping(path = "/keys/encrypt", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> encriptMethod(@RequestParam String textPlain, @RequestParam String idKey) {
		return new ResponseEntity<>(iCipherService.getEncriptText(idKey, textPlain), HttpStatus.OK);

	}

	/**
	 * Metodo de encripcion de un dato
	 * 
	 * @param word
	 * @param idKey
	 * @return
	 */
	@GetMapping(path = "/keys/decrypt", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> decriptMethod(@RequestParam String encryptedText, @RequestParam String idKey) {
		return new ResponseEntity<>(iCipherService.getDecriptText(idKey, encryptedText), HttpStatus.OK);
	}
}
