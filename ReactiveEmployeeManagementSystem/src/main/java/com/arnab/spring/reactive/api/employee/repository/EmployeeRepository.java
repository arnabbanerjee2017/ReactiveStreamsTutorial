package com.arnab.spring.reactive.api.employee.repository;

import com.arnab.spring.reactive.api.employee.domain.Employee;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

public class EmployeeRepository {

	public Mono<Employee> getEmployeeById(String id) {
		return new Mono<Employee>() {

			@Override
			public void subscribe(CoreSubscriber<? super Employee> actual) {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
}
