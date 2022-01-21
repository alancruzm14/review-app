/**
 * 
 */
package com.review.Review.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.review.Review.dto.DefaultError;
import com.review.Review.dto.DefaultErrorList;

import lombok.extern.slf4j.Slf4j;

/**
 * @author macbook
 *
 */
@ControllerAdvice
@Slf4j
public class ReviewHandler {

	/**
	 * Handler que se encarga de tratar todas las excepciones de tipo
	 * CustomLoyaltyException
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ReviewException.class)
	public ResponseEntity<DefaultErrorList> handleReviewControlledException(ReviewException ex) {
		log.error("Traza", ex);
		return new ResponseEntity<>(generaExceptionSalida(ex.getCodigoError(), ex.getMensajeError()),
				ex.getHttpStatus());
	}

	/**
	 * Handler que se encarga de tratar todas las excepciones de tipo
	 * CustomLoyaltyException
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DefaultErrorList> handleValidDtosException(MethodArgumentNotValidException ex) {
		log.error("Traza Validation", ex);
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return new ResponseEntity<>(generaExceptionSalida(errors), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Metodo que utiliza el handler exception, el cual funciona para controlar y
	 * generar la respuesta para casos no controlados
	 * 
	 * @param ex
	 * @return
	 */
	private DefaultErrorList generaExceptionSalida(String codigoError, String mensajeError) {

		String moreInfo = "Ocurrio un error inesperado";// ExceptionUtils.getStackTrace(ex);
		DefaultError dfltError = new DefaultError(codigoError, mensajeError, "Error", generaFolio(), moreInfo);
		log.info("{}", moreInfo);
		log.info(dfltError.toString());
		return new DefaultErrorList(dfltError);
	}

	/**
	 * Metodo que utiliza el handler exception, el cual funciona para controlar y
	 * generar la respuesta para casos no controlados
	 * 
	 * @param ex
	 * @return
	 */
	private DefaultErrorList generaExceptionSalida(Map<String, String> errors) {

		String moreInfo = "Ocurrio un error inesperado";// ExceptionUtils.getStackTrace(ex);
		DefaultError dfltError = new DefaultError();
		dfltError.setFolio(generaFolio());
		dfltError.setMoreInfo(moreInfo);
		dfltError.setCode("000");
		dfltError.setDescription("Parametros Invalidos");
		dfltError.setLevel("Error");
		dfltError.setMoreInformationObject(errors);
		log.info("{}", moreInfo);
		log.info(dfltError.toString());
		return new DefaultErrorList(dfltError);
	}

	/**
	 * Metodo para crear el folio unico por peticion
	 * 
	 * @return
	 */
	public String generaFolio() {
		StringBuilder folio = new StringBuilder();
		folio.append(fecha());
		return folio.toString();
	}

	/**
	 * Metodo para obtener la fecha
	 * 
	 * @return
	 */
	public String fecha() {
		String fecha = "";
		LocalDateTime fecha1 = LocalDateTime.now();
		fecha = obtenerFechaFormateada(fecha1, "yyyy-MM-dd HH:mm:ss.SSS").replaceAll("-", "").replaceAll(" ", "")
				.replaceAll(":", "").replaceAll("\\.", "");
		return fecha;
	}

	/**
	 * Metodo para obtener fecha formateada
	 * 
	 * @param fecha
	 * @param formato
	 * @return
	 */
	private String obtenerFechaFormateada(LocalDateTime fecha, String formato) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formato);
		return fecha.format(dtf);
	}

}
