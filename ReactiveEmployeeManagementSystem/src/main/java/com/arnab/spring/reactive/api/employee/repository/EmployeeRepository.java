/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.spring.reactive.api.employee.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.arnab.spring.reactive.api.employee.domain.Employee;

import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
	Flux<Employee> findByName(String name);
}
