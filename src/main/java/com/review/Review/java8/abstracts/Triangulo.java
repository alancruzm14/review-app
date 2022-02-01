/**
 * 
 */
package com.review.Review.java8.abstracts;

import java.util.Scanner;

/**
 * @author macbook
 *
 */
public class Triangulo extends Figura {

	private double base;
	private double altura;

	public Triangulo(String color, double base, double altura) {
		super(color);
		this.altura = altura;
		this.base = base;
	}

	@Override
	public double calcularArea() {
		return (base * altura) / 2;
	}

	public static void main(String[] args) {
		String colorDelTriangulo;
		double baseDelTriangulo;
		double alturaDelTriangulo;

		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduzca el color del triángulo: ");
		colorDelTriangulo = teclado.nextLine();

		System.out.print("Introduzca la base del triángulo: ");
		baseDelTriangulo = teclado.nextDouble();

		System.out.print("Introduzca la altura del triángulo: ");
		alturaDelTriangulo = teclado.nextDouble();

		Triangulo triangulo1 = new Triangulo(colorDelTriangulo, baseDelTriangulo, alturaDelTriangulo);

		System.out.printf("El área del triángulo %s es: %f", triangulo1.getColor(), triangulo1.calcularArea());
	}
}
