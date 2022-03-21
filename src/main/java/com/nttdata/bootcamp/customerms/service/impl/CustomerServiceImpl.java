package com.nttdata.bootcamp.customerms.service.impl;

import java.util.List;

import com.nttdata.bootcamp.customerms.service.CustomerService;
import com.nttdata.bootcamp.customerms.model.Customer;
import com.nttdata.bootcamp.customerms.repository.CustomerRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementacion del Service de la clase Customer.
 * @version 1.0, 18/03/2022
 * @author Irving Chero
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    
    @Value("${customer.types:PERSONAL, EMPRESARIAL}")
    private List<String> typeCustomer;
    
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String createCustomer(Customer e) {
        logger.info("createCustomer - INICIO");
        if (!typeCustomer.contains(e.getCustomerType())) {
            return "CustomerType invalid!.";
        }
        customerRepository.save(e).subscribe();
        logger.info("createCustomer - FIN");
        return "Customer created successfully!!!.";
    }

    @Override
    public Mono<Customer> findByCustomerId(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public Flux<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> updateCustomer(Customer e) {
        return customerRepository.save(e);
    }

    @Override
    public Mono<Void> deleteCustomer(Integer id) {
        return customerRepository.deleteById(id);
    }
}
