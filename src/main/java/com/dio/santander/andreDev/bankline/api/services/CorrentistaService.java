package com.dio.santander.andreDev.bankline.api.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.andreDev.bankline.api.Dto.CorrentistaDto;
import com.dio.santander.andreDev.bankline.api.model.Correntista;
import com.dio.santander.andreDev.bankline.api.repositories.CorrentistaRepository;


@Service
public class CorrentistaService {

	@Autowired
	private CorrentistaRepository repository;
	
	public List<CorrentistaDto> findAll() {

		List<Correntista> correntistas = repository.findAll();
		
		return correntistas.stream().map(x-> new CorrentistaDto(x)).collect(Collectors.toList());
	}
	
}
