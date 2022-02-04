/**
 * 
 */
package com.review.Review.model.repo1;

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

/**
 * @author Alan
 *
 */
@Getter
@Setter
@Document(collection = "Users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDocument implements Serializable {

	/**
	 * serial id default
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Propiedad de id de mongo
	 */
	private String id;
	/**
	 * usuario del registro del loggeo
	 */
	@Indexed(unique = true)
	private String user;
	/**
	 * Contrasena del registro del usuario
	 */
	private String pass;

	/**
	 * Mail del usuario
	 */
	@Indexed(unique = true)
	private String mail;

	/**
	 * telefono del usuario
	 */
	private String telefono;
	/**
	 * Fecha de regsitro
	 */
	/**
	 * Propiedad para obtener fecha de registro de la llave
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Mexico/General")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime registerDate;

	/**
	 * 
	 */
	public UserDocument() {
		super();
	}

	/**
	 * 
	 * @param user
	 * @param pass
	 * @param registerDate
	 */
	public UserDocument(String user, String pass, String mail,  LocalDateTime registerDate) {
		super();
		this.user = user;
		this.pass = pass;
		this.registerDate = registerDate;
		this.mail = mail;
	}
}
