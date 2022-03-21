package com.nttdata.bootcamp.customerms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Main de la aplicacion springboot.
 * @version 1.0, 18/03/2022
 * @author Irving Chero
 */
@EnableEurekaClient
@SpringBootApplication
public class CustomerMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerMsApplication.class, args);
    }
}
