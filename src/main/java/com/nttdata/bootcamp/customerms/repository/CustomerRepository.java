package com.nttdata.bootcamp.customerms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bootcamp.customerms.model.Customer;

/**
 * Repository de la clase Customer.
 * @version 1.0, 18/03/2022
 * @author Irving Chero
 */
@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, Integer>{

}
