/**
 * 
 */
package com.review.Review.java8.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.base.Optional;

import lombok.Getter;
import lombok.Setter;

/**
 * @author macbook
 *
 */
@Getter
@Setter
public class LambdaTest {

	private String id;
	private String user;

	public LambdaTest(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @param listUsers
	 */
	public void printNames(List<LambdaTest> listUsers) {

		List<String> listUserId = listUsers.stream().filter(var -> var.getUser().length() > 5).map(LambdaTest::getUser)
				.collect(Collectors.toList());

		System.out.println("Lista de usuarios: " + listUserId);
	}

	public static void main(String[] args) {

		// Listas
		List<String> list = new ArrayList<String>();
		list.add("Rick");
		list.add("Negan");
		list.add("Daryl");
		list.add("Glenn");
		list.add("Carl");

		list.forEach((names) -> {
			System.out.println(names);
		});

		// Mapas
		Map<String, Integer> prices = new HashMap<>();
		prices.put("Apple", 50);
		prices.put("Orange", 20);
		prices.put("Banana", 10);
		prices.put("Grapes", 40);
		prices.put("Papaya", 50);

		/*
		 * Iterate without using Lambda for (Map.Entry<String, Integer> entry :
		 * prices.entrySet()) { System.out.println("Fruit: " + entry.getKey() +
		 * ", Price: " + entry.getValue()); }
		 */

		prices.forEach((k, v) -> {
			System.out.println("Fruit: " + k + ", Price: " + v);
		});

		List<LambdaTest> listTest = new ArrayList<LambdaTest>();
		listTest.add(new LambdaTest("galan"));
		listTest.add(new LambdaTest("alan"));
		listTest.add(new LambdaTest("pedro"));
		listTest.add(new LambdaTest("bruno"));
		

		List<String> listIds = new ArrayList<String>();

		listTest.stream().forEach(a -> {
			listIds.add(a.getId());
		});
		System.out.println("\n" + listIds + "\n");

		System.out.println(":::JAVA 8 :: MAP COLLECT - List String of OBJ::::");

		List<String> listIds2 = listTest.stream().map(LambdaTest::getId).collect(Collectors.toList());

		System.out.println("\n" + listIds2 + "\n");

		System.out.println("******");

		Optional<List<LambdaTest>> listTestOpt = Optional.of(listTest);

		if (listTestOpt.isPresent()) {
			List<String> listTestOp = listTestOpt.get().stream().filter(a -> a.getId().equals("alan"))
					.map(LambdaTest::getId).collect(Collectors.toList());

			System.out.println("####### " + listTestOp);
		}

		System.out.println(":::JAVA 8 :: FLATMAP COLLECT - List String of OBJ::::");
		List<String> listIds3 = listTest.stream().flatMap(x -> Arrays.asList(x.getId()).stream()).sorted()
				.collect(Collectors.toList());

		System.out.println("\n" + listIds3 + "\n");

		System.out.println(":::JAVA 8 :: MAPS - Obtain de attribs::::");

		Set<String> keySet = prices.keySet();
		System.out.println(keySet);

		Collection<Integer> values = prices.values();
		System.out.println(values);

	}

}
