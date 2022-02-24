/**
 * 
 */
package com.review.Review.java8.inmmutable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import lombok.Getter;

/**
 * 
 * Una clase inmutable es simplemente aquella cuyas instancias no pueden ser
 * modificadas una vez que su información ha sido definida
 * 
 * 
 * Si marcamos la clase como final, evitamos que a través de la herencia, una
 * subclase consiga acceso a los atributos de la clase padre y modifique sus
 * valores.
 * 
 * 
 * @author macbook
 *
 */
@Getter
class InmutableClass {

	private String name;

	private LocalDateTime birthday;

	public InmutableClass(String name, LocalDateTime birthday) {
		name = name;
		birthday = birthday;
	}

	public String getBirthday() {
		return birthday.getMonthValue() + "/" + birthday.getDayOfMonth();
	}

	public static void main(String[] args) {
		int fac = 1;
		int n = 5;
		
		for(int i = 1; i< n; i++) {
			fac *= i;
		}
		System.out.println("resultado " + fac);
		
		LocalDate dt = LocalDate.parse("2015-01-01").minusMonths(1).minusDays(1).plusYears(1);
		System.out.println(dt);
		
		String a = "abc";
		String b = new String("abc");
		
		System.out.println("resultado: " + a == b);

	}


}
