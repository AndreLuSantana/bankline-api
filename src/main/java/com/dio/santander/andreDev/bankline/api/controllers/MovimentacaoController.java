package com.dio.santander.andreDev.bankline.api.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dio.santander.andreDev.bankline.api.Dto.CorrentistaDto;
import com.dio.santander.andreDev.bankline.api.Dto.MovimentacaoDto;
import com.dio.santander.andreDev.bankline.api.model.Movimentacao;
import com.dio.santander.andreDev.bankline.api.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public ResponseEntity<List<MovimentacaoDto>> findAll(){
		List<MovimentacaoDto> movimentacaoDto = service.findAll();
		return ResponseEntity.ok().body(movimentacaoDto);
		
	}
	
	@PostMapping
	public ResponseEntity<MovimentacaoDto> movimentacao(@RequestBody Movimentacao obj){
		MovimentacaoDto movimentacaoDto = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(movimentacaoDto).toUri();
		return ResponseEntity.created(uri).build();
	}
}
