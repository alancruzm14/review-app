/**
 * 
 */
package com.review.Review.java8.interfaces;

/**
 * Interfaces funcionales, hay 2 modos de definirla, 1 es agregando un metodo
 * abstracto que en este casp es el sayHelloWord
 * 
 * @author macbook
 *
 */
@FunctionalInterface
public interface FuncionalInterface {

	public String sayHelloTo(String name);

//	public default String sayHelloWord() {
//		return "Hello word";
//	}

	public default String sayHelloWord() {
		return "Hello word";
	}

	public static void main(String[] args) {
		FuncionalInterface strategy = (nome) -> "Holaaaa " + nome;

		System.out.println(strategy.sayHelloTo("Oscar Blancarte"));
		System.out.println(strategy.sayHelloWord());
	}
}
