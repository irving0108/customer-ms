package com.nttdata.bootcamp.customerms.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Customer {
	int id;
	String customerType;
	String name;
	String lastName;
	String documentType;
	String documentNumber;
	String businessName;	
}
