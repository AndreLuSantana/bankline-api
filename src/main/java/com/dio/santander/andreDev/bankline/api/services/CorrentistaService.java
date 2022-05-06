package com.dio.santander.andreDev.bankline.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.andreDev.bankline.api.model.Correntista;
import com.dio.santander.andreDev.bankline.api.repositories.CorrentistaRepository;


@Service
public class CorrentistaService {

	@Autowired
	private CorrentistaRepository repository;
	
	public List<Correntista> findAll() {

		List<Correntista> correntistas = repository.findAll();
		
		return correntistas;
	}

	
	
}
