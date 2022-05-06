package com.dio.santander.andreDev.bankline.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
