/**
 * 
 */
package com.review.Review.java8.threads;

/**
 * @author macbook
 *
 */
public class ThreadExample extends Thread {

	private String nombre;
	private int retardo;

	// Constructor para almacenar nuestro nombre
	// y el retardo
	public ThreadExample(String s, int d) {
		nombre = s;
		retardo = d;
	}

	// El metodo run() es similar al main(), pero para
	// threads. Cuando run() termina el thread muere
	public void run() {
		// Retasamos la ejecución el tiempo especificado
		try {
			sleep(retardo);
		} catch (InterruptedException e) {
			;
		}

		// Ahora imprimimos el nombre
		System.out.println("Hola Mundo! " + nombre + " " + retardo + " " + currentThread());
	}

	public static void main(String[] args) {

		ThreadExample t1, t2, t3;

		int random1 = (int) (Math.random() * 2000);
		int random2 = (int) (Math.random() * 2000);
		int random3 = (int) (Math.random() * 2000);

		System.out.println("Random 1: " + random1);
		System.out.println("Random 2: " + random2);
		System.out.println("Random 3: " + random3);

		// Creamos los threads
		t1 = new ThreadExample("Thread 1", random1);
		t2 = new ThreadExample("Thread 2", random2);
		t3 = new ThreadExample("Thread 3", random3);

		// Arrancamos los threads
		t1.start();
		t2.start();
		t3.start();
	}

}
