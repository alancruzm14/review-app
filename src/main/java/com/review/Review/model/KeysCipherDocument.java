/**
 * 
 */
package com.review.Review.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alan
 *
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "KeysDocument")
public class KeysCipherDocument implements Serializable {

	/**
	 * id generado
	 */
	private static final long serialVersionUID = 6014296696759121693L;

	/**
	 * Propiedad de id de mongo
	 */
	private String id;

	/**
	 * Propiedad de id para los keys
	 */
	@Indexed(unique = true)
	private String idKey;

	/**
	 * Propiedad para obtener la llave publica
	 */
	private String publicKey;

	/**
	 * Propiedad para obtener la llave privada
	 */
	private String privateKey;

	/**
	 * Propiedad para obtener fecha de registro de la llave
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Mexico/General")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime dateRegister;

}
