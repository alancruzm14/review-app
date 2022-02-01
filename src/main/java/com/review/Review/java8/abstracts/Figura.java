/**
 * 
 */
package com.review.Review.java8.abstracts;

/**
 * 
 * En una clase abstracta es posible definir métodos abstractos, los cuales se
 * caracterizan por el hecho de que no pueden ser implementados en la clase
 * base. De ellos, solo se escribe su signatura en la superclase, y su
 * funcionalidad
 * 
 * @author macbook
 *
 */
public abstract class Figura {

	private String color;

	/**
	 * constructor
	 * 
	 * @param color
	 */
	public Figura(String color) {
		this.color = color;
	}

	/**
	 * Metodo abstracto
	 * 
	 * @return
	 */
	public abstract double calcularArea();

	/**
	 * Get del valor color
	 * 
	 * @return
	 */
	public String getColor() {
		return color;
	}
}
