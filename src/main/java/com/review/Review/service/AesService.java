package com.review.Review.service;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 
 * @author macbook
 *
 */
@Service
public class AesService implements IAesService {

//	private static final String secretKeyAES = "alexastudillo32digitosclaveaes25";
//	private static final String saltAES = "alex1234";
//	private static final String ivsAES = "6jAxSS0wsd0xMlQY";

	public static final String UTF_8 = "UTF-8";

	/**
	 * Atributo que contiene
	 */
	@Value("${aes.users.key}")
	private String secretKeyAES;

	/**
	 * Atributo que contiene
	 */
	@Value("${aes.users.salt}")
	private String saltAES;

	/**
	 * Atributo que contiene
	 */
	@Value("${aes.users.iv}")
	private String ivsAES;

	/**
	 * Metodo para encriptar con aes
	 */
	@Override
	public String getAES(String texto) {
		try {
			SecretKeySpec secretKey = generateSecretKey();
			// Inicia parte Cifrado
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

			IvParameterSpec iv = new IvParameterSpec(ivsAES.getBytes(UTF_8));
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
			return Base64.getEncoder().encodeToString(cipher.doFinal(texto.getBytes("UTF-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Metodo para des encriptar con aes
	 */
	@Override
	public String getAESDecrypt(String textoCifrado) {
		try {
			// Generacion de llaves
			SecretKeySpec secretKey = generateSecretKey();
			// Inicia parte Cifrado
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(ivsAES.getBytes(UTF_8));
			cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
			return new String(cipher.doFinal(Base64.getDecoder().decode(textoCifrado)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private SecretKeySpec generateSecretKey() {
		SecretKeySpec secretKey = null;
		try {
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec keySpec = new PBEKeySpec(secretKeyAES.toCharArray(), saltAES.getBytes(), 65536, 256);
			SecretKey secretKeyTemp = secretKeyFactory.generateSecret(keySpec);
			secretKey = new SecretKeySpec(secretKeyTemp.getEncoded(), "AES");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return secretKey;
	}

}
