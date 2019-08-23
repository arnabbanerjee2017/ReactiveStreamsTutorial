package com.arnab.spring.reactive.api.demo;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;

public class StockServer {

	public static Observable<StockInfo> getFeed(List<String> symbols) {
		return Observable.create(subscriber -> emit(subscriber));
	}

	private static void emit(ObservableEmitter<StockInfo> subscriber) {
		System.out.println("Start emitting....");
	}
	
}
