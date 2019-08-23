/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.spring.reactive.api.employee.basics;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// A simple flux of integers from 1 to 10.
		Flux<Integer> flux = Flux.range(1, 10);
		flux = flux.map(s -> s + 100);
		flux.subscribe(System.out::println);

		// A simple flux of List of Strings.
		// This demonstrates using a map().
		Flux<String> fluxFromList = Flux.fromIterable(getNamesOfCities());
		fluxFromList = fluxFromList.delayElements(Duration.ofMillis(100));
		
		//fluxFromList = fluxFromList.doOnNext(Main::makeFirstLetterCap); // not working as expected...
		
		fluxFromList = fluxFromList.map(Main::makeFirstLetterCap);
		
		//fluxFromList = fluxFromList.take(3); // just to take 3 items out of the flux...

		System.out.println("----------------------------------------------------------------------------");

		// This demonstrates using a flatMap()
		Flux<String> fluxFromListUsingFlatMap = Flux.fromIterable(getNamesOfCities());
		fluxFromListUsingFlatMap = fluxFromListUsingFlatMap.delayElements(Duration.ofMillis(100));
		fluxFromListUsingFlatMap = fluxFromListUsingFlatMap.flatMap(s -> {
				String[] values = s.split(" ");
				for(int i = 0; i < values.length; i++) {
					String firstChar = values[i].substring(0, 1);
					String restChars = values[i].substring(1);
					values[i] = firstChar.toUpperCase() + restChars.toLowerCase();
				}
				String value = "";
				for(String tempValue: values) {
					value += tempValue + " ";
				}
				return Flux.just("<> " + value);
			});

		// Subscribing the fluxes.
		fluxFromList.subscribe(System.out::println);
		fluxFromListUsingFlatMap.subscribe(System.out::println);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("----------------------------------------------------------------------------");

		// Merging two fluxes.
		Flux<String> fluxMerged = Flux.concat(fluxFromList, fluxFromListUsingFlatMap);
		fluxMerged.subscribe(System.out::println);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}			
		
	}
	
	private static List<String> getNamesOfCities() {
		List<String> list = Arrays.asList("kolkata", "new delhi", "pune", "mumbai", "chennai", "bangalore", "hyderabad");
		list.sort((x, y) -> x.compareTo(y));
		return list;
	}
	
	private static String makeFirstLetterCap(String value) {
		String[] values = value.split(" ");
		for(int i = 0; i < values.length; i++) {
			String firstChar = values[i].substring(0, 1);
			String restChars = values[i].substring(1);
			values[i] = firstChar.toUpperCase() + restChars.toLowerCase();
		}
		value = "";
		for(String tempValue: values) {
			value += tempValue + " ";
		}
		return "-> " + value.trim();
	}
}
