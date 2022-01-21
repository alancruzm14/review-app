package com.review.Review.component;

import java.util.Base64;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.extern.slf4j.Slf4j;

/**
 * Componente de conversion de datos
 * 
 * @author Alan
 *
 */
@Component
@Slf4j
public class AuxComponent {

	/**
	 * Metodo de conversion de bytes a String
	 * 
	 * @param byteObj
	 * @return
	 */
	public String getStringByBytes(byte[] byteObj) {
		return Base64.getEncoder().encodeToString(byteObj);
	}

	/**
	 * Metodo para convertir objs a json
	 * 
	 * @param object
	 * @return
	 */
	public String getJsonByObj(Object object) {
		String json = "";
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			json = ow.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			log.error(e.getLocalizedMessage());
		}

		return json;
	}

}
