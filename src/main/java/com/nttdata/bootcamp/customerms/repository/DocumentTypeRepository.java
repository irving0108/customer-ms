package com.nttdata.bootcamp.customerms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bootcamp.customerms.model.DocumentType;

@Repository
public interface DocumentTypeRepository extends ReactiveMongoRepository<DocumentType, Integer>{

}
