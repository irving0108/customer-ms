package com.nttdata.bootcamp.customerms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.customerms.model.DocumentType;
import com.nttdata.bootcamp.customerms.repository.DocumentTypeRepository;
import com.nttdata.bootcamp.customerms.service.DocumentTypeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService{
	
	@Autowired
	DocumentTypeRepository documentTypeRepository;

	@Override
	public void createType(DocumentType e) {
		documentTypeRepository.save(e).subscribe();
	}

	@Override
	public Mono<DocumentType> findByTypeId(Integer id) {
		return documentTypeRepository.findById(id);
	}

	@Override
	public Flux<DocumentType> findAllType() {
		return documentTypeRepository.findAll();
	}

	@Override
	public Mono<DocumentType> updateType(DocumentType e) {
		return documentTypeRepository.save(e);
	}

	@Override
	public Mono<Void> deleteType(Integer id) {
		return documentTypeRepository.deleteById(id);
	}

}
