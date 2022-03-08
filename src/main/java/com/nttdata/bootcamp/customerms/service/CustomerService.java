package com.nttdata.bootcamp.customerms.service;

import com.nttdata.bootcamp.customerms.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
	void createCustomer(Customer e);
	Mono<Customer> findByCustomerId(Integer id);
	Flux<Customer> findAllCustomer();
	Mono<Customer> updateCustomer(Customer e);
    Mono<Void> deleteCustomer(Integer id);
}
