package com.arnab.spring.reactive.api.employee.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.arnab.spring.reactive.api.employee.domain.Employee;

import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
	Flux<Employee> findByName(String name);
}
