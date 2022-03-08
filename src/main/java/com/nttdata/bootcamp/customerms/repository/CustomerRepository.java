package com.nttdata.bootcamp.customerms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bootcamp.customerms.model.Customer;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, Integer>{

}
