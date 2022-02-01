/**
 * 
 */
package com.review.Review.java8.abstracts;

/**
 * 
 * Con una clase de este tipo se tiene la  posibilidad de declarar clases que  definen cómo se utiliza solamente, sin  tener que implementar métodos. 
 * 
 * Las subclases de una clase abstracta  debe sobreescribir todos los métodos  abstractos. 
 * 
 * Las subclases de una clase abstracta  deben ser declaradas como clases  abstractas. 
 * 
 * Una clase abstracta puede incluir  miembros no abstractos.
 * 
 * No se puede instanciar una clase  abstracta pero sí crear referencias de  ella. 
 * 
 * Si se desea que una clase no sea abstracta  entonces basta con que el cuerpo del  método(s) abstract sea vacío.
 * 
 * @author macbook
 *
 */
public abstract class ClasePadre1 {

	public double metodo1() {
		// acciones
		return 0;
	}

	public abstract void metodo2();

}
