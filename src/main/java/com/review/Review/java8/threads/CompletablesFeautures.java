/**
 * 
 */
package com.review.Review.java8.threads;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author macbook
 *
 */
public class CompletablesFeautures {

	public static void main(String[] args) {
//		CompletableFuture<String> completableFuture = new CompletableFuture<String>();
//		
//		try {
//			completableFuture.complete("Future's Result");
//			String result = completableFuture.get();
//			System.out.println(result);
//
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("Start Prog: " + LocalDateTime.now());

		/**
		 * Definicion del trhead
		 */
		CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				try {
					System.out.println("Got a sleep 1 secod");
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					throw new IllegalStateException(e);
				}
				return "Result of the asynchronous computation";
			}
		});

		String result = "";
		try {

			// Ejecucion del thread
			System.out.println("Start get: " + LocalDateTime.now());
			result = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		System.out.println("End: " + LocalDateTime.now());

	}
}
