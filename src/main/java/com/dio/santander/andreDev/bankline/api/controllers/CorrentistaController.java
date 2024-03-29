package com.dio.santander.andreDev.bankline.api.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dio.santander.andreDev.bankline.api.Dto.CorrentistaDto;
import com.dio.santander.andreDev.bankline.api.model.Correntista;
import com.dio.santander.andreDev.bankline.api.services.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
	
	@Autowired
	private CorrentistaService service;

	@GetMapping
	public ResponseEntity<List<CorrentistaDto>> findAll(){
		List<CorrentistaDto> correntistas = service.findAll();
		return ResponseEntity.ok().body(correntistas);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CorrentistaDto> findById(@PathVariable Integer id){
		Correntista correntista = service.findById(id);
		return ResponseEntity.ok().body(new CorrentistaDto(correntista));
	}
	
	@PostMapping
	public ResponseEntity<CorrentistaDto> save(@RequestBody Correntista obj){
		CorrentistaDto correntistaDto = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(correntistaDto).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CorrentistaDto> update(@PathVariable Integer id, @RequestBody CorrentistaDto correntistaDto){
		Correntista correntista = service.update(id, correntistaDto);
		return ResponseEntity.ok().body(new CorrentistaDto(correntista));
	}
}
