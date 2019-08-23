package com.arnab.spring.reactive.api.demo;

import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class ReactiveJavaDemo {

	public static void main(String[] args) {

		final List<String> list = Arrays.asList("GOOG", "AMZN", "INTC", "MSFT");
		
		final Observable<StockInfo> feed = StockServer.getFeed(list);
		System.out.println("Got observable...");
		
		feed.subscribe(System.out::println);
	}

}
