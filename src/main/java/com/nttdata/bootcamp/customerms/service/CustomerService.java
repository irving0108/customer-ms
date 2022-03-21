package com.nttdata.bootcamp.customerms.service;

import com.nttdata.bootcamp.customerms.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service de la clase Customer.
 * @version 1.0, 18/03/2022
 * @author Irving Chero
 */
public interface CustomerService {
    String createCustomer(Customer e);
    Mono<Customer> findByCustomerId(Integer id);
    Flux<Customer> findAllCustomer();
    Mono<Customer> updateCustomer(Customer e);
    Mono<Void> deleteCustomer(Integer id);
}
