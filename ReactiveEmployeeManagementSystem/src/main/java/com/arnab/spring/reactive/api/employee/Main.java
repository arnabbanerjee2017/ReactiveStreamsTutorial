package com.arnab.spring.reactive.api.employee;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;

public class Main {
	public static void main(String[] args) {
		Flux<Integer> flux = Flux.range(1, 10);
		flux = flux.map(s -> s + 100);
		flux.subscribe(System.out::println);
		
		Flux<String> fluxFromList = Flux.fromIterable(getNamesOfCities());
		fluxFromList = fluxFromList.delayElements(Duration.ofMillis(100));
		//fluxFromList = fluxFromList.doOnNext(Main::makeFirstLetterCap); // not working as expected...
		fluxFromList = fluxFromList.map(Main::makeFirstLetterCap);
		//fluxFromList = fluxFromList.take(3); // just to take 3 items out of the flux...
		fluxFromList.subscribe(System.out::println);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}			
		
	}
	
	private static List<String> getNamesOfCities() {
		return Arrays.asList("kolkata", "new delhi", "pune", "mumbai", "chennai", "bangalore", "hyderabad");
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
		return value.trim();
	}
}
