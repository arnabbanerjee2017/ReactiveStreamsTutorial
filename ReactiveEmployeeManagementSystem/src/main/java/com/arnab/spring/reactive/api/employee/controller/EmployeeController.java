/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.spring.reactive.api.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.spring.reactive.api.employee.domain.Employee;
import com.arnab.spring.reactive.api.employee.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@GetMapping(value = "/byid/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Mono<Employee> getEmployeeById(@PathVariable String id) {
		return service.getById(id);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public Flux<Employee> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value = "/byname/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Flux<Employee> getByName(@PathVariable String name) {
		return service.getByName(name);
	}
	
	@GetMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Mono<Employee> save(@RequestParam String name, 
								@RequestParam String city,
								@RequestParam String pincode, 
								@RequestParam String job) {
		return service.save(name, city, pincode, job);
	}
	
}
