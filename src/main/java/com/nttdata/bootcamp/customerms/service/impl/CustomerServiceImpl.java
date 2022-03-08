package com.nttdata.bootcamp.customerms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.customerms.model.Customer;
import com.nttdata.bootcamp.customerms.repository.CustomerRepository;
import com.nttdata.bootcamp.customerms.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Value("${customer.types}")  
	private List<String> typeCustomer;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public String createCustomer(Customer e) {
		if(!typeCustomer.contains(e.getCustomerType())) {
			return "CustomerType invalid!.";
		}
		customerRepository.save(e).subscribe();
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
