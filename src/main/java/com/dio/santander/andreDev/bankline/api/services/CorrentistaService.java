package com.dio.santander.andreDev.bankline.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.andreDev.bankline.api.Dto.CorrentistaDto;
import com.dio.santander.andreDev.bankline.api.model.Conta;
import com.dio.santander.andreDev.bankline.api.model.Correntista;
import com.dio.santander.andreDev.bankline.api.repositories.CorrentistaRepository;
import com.dio.santander.andreDev.bankline.api.services.exception.ObjectNotFoundException;

@Service
public class CorrentistaService {

	@Autowired
	private CorrentistaRepository repository;

	public List<CorrentistaDto> findAll() {

		List<Correntista> correntistas = repository.findAll();

		return correntistas.stream().map(x -> new CorrentistaDto(x)).collect(Collectors.toList());
	}

	public Correntista findById(Integer id) {
		Optional<Correntista> correntista = repository.findById(id);
		return correntista.orElseThrow(() -> new ObjectNotFoundException("Correntista inexistente."));
	}

	public CorrentistaDto save(Correntista obj) {
		
		if(obj.getConta() == null || obj.getConta().getNumero() == 0) {
			obj.setConta(new Conta());
		}
		Correntista correntista = repository.save(obj);
		return new CorrentistaDto(correntista);
	}

	public Correntista update(Integer id, CorrentistaDto obj) {
		
		Correntista correntista = findById(id);
		updatedata(correntista, obj);
		repository.save(correntista);
		return correntista;
	}

	private void updatedata(Correntista correntista, CorrentistaDto obj) {
		correntista.setConta(obj.getConta());
		correntista.setCpf(obj.getCpf());
		correntista.setConta(obj.getConta());
	}
}
