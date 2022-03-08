package com.nttdata.bootcamp.customerms.service;

import com.nttdata.bootcamp.customerms.model.DocumentType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DocumentTypeService {
	void createType(DocumentType e);
	Mono<DocumentType> findByTypeId(Integer id);
	Flux<DocumentType> findAllType();
	Mono<DocumentType> updateType(DocumentType e);
    Mono<Void> deleteType(Integer id);
}
