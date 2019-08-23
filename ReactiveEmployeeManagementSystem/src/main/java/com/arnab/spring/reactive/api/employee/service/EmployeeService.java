package com.arnab.spring.reactive.api.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.spring.reactive.api.employee.domain.Employee;
import com.arnab.spring.reactive.api.employee.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	public Flux<Employee> getAll() {
		return repo.findAll();
	}
	
	public Mono<Employee> getById(String id) {
		return repo.findById(id);
	}
	
	public Flux<Employee> getByName(String name) {
		return repo.findByName(name);
	}
	
	public Mono<Employee> save(String name, String city, String pincode, String job) {
		return repo.save(new Employee(name, city, pincode, job))
					.doOnSuccess(System.out::println);
	}
	
}
