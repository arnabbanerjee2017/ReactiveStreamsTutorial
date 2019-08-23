package com.arnab.spring.reactive.api.employee.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.spring.reactive.api.employee.domain.Employee;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	public Mono<Employee> getEmployeeById(@PathVariable String id) {
		return null;
	}
	
}
