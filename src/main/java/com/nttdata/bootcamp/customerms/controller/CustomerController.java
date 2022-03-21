package com.nttdata.bootcamp.customerms.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.customerms.model.Customer;
import com.nttdata.bootcamp.customerms.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller que expone los servicios del customer.
 * @version 1.0, 18/03/2022
 * @author Irving Chero
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String createCustomer(@RequestBody Customer customer) {
        logger.info("CustomerController - createCustomer - customer: {}", customer);
        return customerService.createCustomer(customer);
    }
    
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Customer> updateCustomer(@PathVariable("id") Integer id, 
            @RequestBody Customer customer) {
        logger.info("CustomerController - updateCustomer - customer: {}", customer);
        return customerService.updateCustomer(customer);
    }
    
    @GetMapping(value = "", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Customer> findAll(){
        logger.info("CustomerController - findAll");
        return customerService.findAllCustomer();
    }
    
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Mono<Customer>> findById(@PathVariable("id") Integer id){
        logger.info("CustomerController - findById - id : {}", id);
        Mono<Customer> customermono = customerService.findByCustomerId(id);
        return new ResponseEntity<Mono<Customer>>(customermono, customermono != null ? 
                HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Customer> delete(@PathVariable("id") Integer id) {
        logger.info("CustomerController - delete - id : {}", id);
        final Mono<Customer> dbcustomer = customerService.findByCustomerId(id);
        if (Objects.isNull(dbcustomer)) {
           return Mono.empty();
        }
        return customerService.findByCustomerId(id).switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(customerToBeDeleted -> customerService
            .deleteCustomer(id).then(Mono.just(customerToBeDeleted)));
    }
}
