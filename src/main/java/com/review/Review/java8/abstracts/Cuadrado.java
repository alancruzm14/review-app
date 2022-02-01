/**
 * 
 */
package com.review.Review.java8.abstracts;

import java.util.Scanner;

/**
 * @author macbook
 *
 */
public class Cuadrado extends Figura {

	private double lado;

	public Cuadrado(String color, double lado) {
		super(color);
		this.lado = lado;
	}

	@Override
	public double calcularArea() {
		return lado * lado;
	}

	public static void main(String[] args) {
		String colorDelCuadrado;
		double ladoDelCuadrado;

		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduzca el color del cuadrado: ");
		colorDelCuadrado = teclado.nextLine();

		System.out.print("Introduzca el lado del cuadrado: ");
		ladoDelCuadrado = teclado.nextDouble();

		Cuadrado cuadrado1 = new Cuadrado(colorDelCuadrado, ladoDelCuadrado);

		System.out.printf("El área del cuadrado %s es: %f", cuadrado1.getColor(), cuadrado1.calcularArea());
	}
}
