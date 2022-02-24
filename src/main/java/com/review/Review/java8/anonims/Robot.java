package com.review.Review.java8.anonims;

import lombok.Getter;
import lombok.Setter;

/**
 * Clases internas anonimas
 * 
 * @author macbook
 *
 */
@Getter
@Setter
public class Robot {

	private int x;
	private DescripcionRobot descripcion;

	public Robot(int x) {
		this.x = x;
		this.descripcion = new DescripcionRobot();
	}

	// clase interna
	public class DescripcionRobot {
		private String nombre, color;

		public DescripcionRobot() {
			if (x > 0) {
				this.nombre = "A";
				this.color = "blanco";
			} else {
				this.nombre = "B";
				this.color = "rojo";
			}

		}
	}

	public void avanzar(int d) {
		this.x += d;
	}

	public int valorX() {
		return this.x;
	}

	public void asignarX(int x) {
		this.x = x;
	}

	public String toString() {
		return "Robot(" + this.x + ")";
	}

//	public static void main(String[] args) {
//		Robot.DescripcionRobot r = (new Robot(3)).new DescripcionRobot();
//		System.out.println(r.color);
//		System.out.println(r.nombre);
//
//	}

}
