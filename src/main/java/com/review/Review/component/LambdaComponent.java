/**
 * 
 */
package com.review.Review.component;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

/**
 * @author macbook
 *
 */
@Slf4j
public class LambdaComponent {
	public static void main(String[] args) {

		ArrayList<Integer> precios = new ArrayList<Integer>();
		precios.add(1);
		precios.add(12);
		precios.add(14);
		precios.add(5);
		precios.add(4);
		precios.add(1);

		int precioTotalLambda = precios.stream().mapToInt(precio -> precio.intValue()).sum();

		int precioTotalRefMethod = precios.stream().mapToInt(Integer::intValue).sum();

		log.info("Lamda {}", precioTotalLambda);
		log.info("RefMethod {}", precioTotalRefMethod);

	}
}
