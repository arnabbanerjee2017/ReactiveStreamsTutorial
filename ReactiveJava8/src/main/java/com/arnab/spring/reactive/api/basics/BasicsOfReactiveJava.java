package com.arnab.spring.reactive.api.basics;

import io.reactivex.rxjava3.core.Observable;

public class BasicsOfReactiveJava {
	public static void main(String[] args) {
		Observable<String> myObs = Observable.just("Hello, World!!! Keep Emiting!");
		
		myObs.subscribe(subscriber -> printCaps(subscriber), System.out::println, System.out::println);
	}
	
	private static void printCaps(String s) {
		System.out.println(s.toUpperCase());
	}
}
