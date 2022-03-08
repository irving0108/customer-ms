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

import com.nttdata.bootcamp.customerms.model.DocumentType;
import com.nttdata.bootcamp.customerms.service.DocumentTypeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/documenttype")
public class DocumentTypeController {

	@Autowired
	DocumentTypeService documentTypeService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createDocumentType(@RequestBody DocumentType documentType) {
		documentTypeService.createType(documentType);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<DocumentType> updateDocumentType(@PathVariable("id") Integer id, @RequestBody DocumentType documentType) {
		return documentTypeService.updateType(documentType);
	}
	
	@GetMapping(value = "", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ResponseBody
	public Flux<DocumentType> findAll(){
		return documentTypeService.findAllType();
	}
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Mono<DocumentType>> findById(@PathVariable("id") Integer id){
		Mono<DocumentType> documenttype = documentTypeService.findByTypeId(id);
		return new ResponseEntity<Mono<DocumentType>>(documenttype, documenttype != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<DocumentType> delete(@PathVariable("id") Integer id) {
		final Mono<DocumentType> dbdocument = documentTypeService.findByTypeId(id);
		if (Objects.isNull(dbdocument)) {
		   return Mono.empty();
		}
		return documentTypeService.findByTypeId(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(documentTypeToBeDeleted -> documentTypeService
		    .deleteType(id).then(Mono.just(documentTypeToBeDeleted)));
	}
}
