package com.review.Review.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * La clase ErrorBean, usada para indicar los errores que sucedieron durante la
 * ejecucion.
 * 
 * @author Transformacion Digital
 */
@Getter
@Setter
@ToString
public class DefaultError implements Serializable {

	/** Variable para serializar la clase. */
	private static final long serialVersionUID = 1L;
	/** La variable code. */
	private String code;
	/** La variable message. */
	private String message;
	/** La variable level. */
	private String level;
	/** La variable description. */
	private String description;
	/** La variable more info. */
	private String moreInfo;
	/** La variable folio. */
	private String folio;
	/***
	 * Objectos con informacion addicional
	 */
	private Object moreInformationObject;

	/**
	 * @param code        Un codigo de error unico, el cual pueda ser identificado y
	 *                    localizado para mas detalles. Debe ser human readable, por
	 *                    tanto no deberia ser un codigo numerico, sino
	 *                    alfanumerico.
	 * @param message     Un mensaje de error claro: Por consideraciones de
	 *                    seguridad estos mensajes de error no deben contener
	 *                    informacion interna que pudiera implicar un riesgo a la
	 *                    seguridad e integridad.
	 * @param level       Un nivel de error: info, warning, error.
	 * @param description Una descripcion detallada.
	 * @param moreInfo    Un link a la documentacion del codigo de error.
	 */
	public DefaultError(String code, String message, String level, String description, String moreInfo) {
		this.code = code;
		this.message = message;
		this.level = level;
		this.description = description;
		this.moreInfo = moreInfo;
	}

	/**
	 * @param code        Un codigo de error unico, el cual pueda ser identificado y
	 *                    localizado para mas detalles. Debe ser human readable, por
	 *                    tanto no deberia ser un codigo numerico, sino
	 *                    alfanumerico.
	 * @param message     Un mensaje de error claro: Por consideraciones de
	 *                    seguridad estos mensajes de error no deben contener
	 *                    informacion interna que pudiera implicar un riesgo a la
	 *                    seguridad e integridad.
	 * @param level       Un nivel de error: info, warning, error.
	 * @param description Una descripcion detallada.
	 * @param moreInfo    Un link a la documentacion del codigo de error.
	 */
	public DefaultError(String code, String message, String level, String description, String moreInfo, String folio,
			Object moreInformationObject) {
		this.code = code;
		this.message = message;
		this.level = level;
		this.description = description;
		this.moreInfo = moreInfo;
		this.folio = folio;
		this.moreInformationObject = moreInformationObject;
	}

	public DefaultError() {
		super();
	}

}
