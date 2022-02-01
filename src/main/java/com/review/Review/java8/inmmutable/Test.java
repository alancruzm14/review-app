/**
 * 
 */
package com.review.Review.java8.inmmutable;

/**
 * @author macbook
 *
 */
public class Test {
	static {
		System.out.println("static");
	}
	
	public Test() {
		System.out.println("Constructor");
	}
	
	public static void main(String[] args) {
		Test t = new Test();
	}
}
