/**
 * 
 */
package com.review.Review.service;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.Review.component.AuxComponent;
import com.review.Review.dto.KeysCipherTO;
import com.review.Review.model.KeysCipherDocument;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Alan
 *
 */
@Slf4j
@Service
public class CipherService implements ICipherService {

	private static final String INSTANCE_CIPHER = "RSA";

	@Autowired
	private AuxComponent auxComponent;

	/**
	 * Metodo para obtener la llave publica aleatoria
	 */
	@Override
	public KeysCipherTO getPublicKey() {
		log.info("Metodo para obtener la llave publica");
		PrivateKey privateKey = null;
		PublicKey publicKey = null;
		try {
			KeyPairGenerator keyGen;
			keyGen = KeyPairGenerator.getInstance(INSTANCE_CIPHER);
			keyGen.initialize(2048);
			KeyPair keyPair = keyGen.genKeyPair();
			privateKey = keyPair.getPrivate();
			publicKey = keyPair.getPublic();

		} catch (NoSuchAlgorithmException e) {
			log.error("Error: {}", e);
		}
		String uniqueID = UUID.randomUUID().toString();
		String privateKeyStr = auxComponent.getStringByBytes(privateKey.getEncoded());
		String publicKeyStr = auxComponent.getStringByBytes(publicKey.getEncoded());
		saveKeys(uniqueID, privateKeyStr, publicKeyStr);

		KeysCipherTO keys = new KeysCipherTO();
		keys.setIdKey(uniqueID);
		keys.setPublicKey(publicKeyStr);

		return keys;
	}

	/**
	 * guardado en coleccion
	 * 
	 * @param key
	 * @param privateKey
	 * @param publicKey
	 */
	private void saveKeys(String key, String privateKey, String publicKey) {

		KeysCipherDocument keysCipherDocument = new KeysCipherDocument();
		keysCipherDocument.setIdKey(key);
		keysCipherDocument.setPrivateKey(privateKey);
		keysCipherDocument.setPublicKey(publicKey);
		keysCipherDocument.setDateRegister(LocalDateTime.now());
	}

	/**
	 * Texto a descrifrar
	 */
	@Override
	public String getDescipherText(String idKey, String cipherText) {
		log.info("Metodo para descifrar");
		return null;
	}

	/**
	 * Metodo para obtener una llave publica
	 * 
	 * @param base64PublicKey
	 * @return
	 */
	private PublicKey getPublicKey(String base64PublicKey) {
		PublicKey publicKey = null;
		try {
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
			KeyFactory keyFactory = KeyFactory.getInstance(INSTANCE_CIPHER);
			publicKey = keyFactory.generatePublic(keySpec);
			return publicKey;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return publicKey;
	}

	private PrivateKey getPrivateKey(String base64PrivateKey) {
		PrivateKey privateKey = null;
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
		KeyFactory keyFactory = null;
		try {
			keyFactory = KeyFactory.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			privateKey = keyFactory.generatePrivate(keySpec);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return privateKey;
	}

	private byte[] encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException,
			InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
		return cipher.doFinal(data.getBytes());
	}

	private String decrypt(byte[] data, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return new String(cipher.doFinal(data));
	}

	private String decrypt(String data, String base64PrivateKey) throws IllegalBlockSizeException, InvalidKeyException,
			BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		return decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey(base64PrivateKey));
	}

}
