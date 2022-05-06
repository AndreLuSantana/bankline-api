package com.dio.santander.andreDev.bankline.api.services.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.andreDev.bankline.api.model.Conta;
import com.dio.santander.andreDev.bankline.api.model.Correntista;
import com.dio.santander.andreDev.bankline.api.repositories.CorrentistaRepository;

@Service
public class DBService {

	@Autowired
	private CorrentistaRepository correntistaRepository;

	public void instanciaDB() {

		Conta conta = new Conta();

		Correntista correntista = new Correntista();
		correntista.setCpf("81760248215");
		correntista.setNome("André Luiz Santana");
		correntista.setConta(conta);

		Conta conta1 = new Conta();

		Correntista correntista1 = new Correntista();
		correntista1.setCpf("65432198715");
		correntista1.setNome("Karleane Cleica Lobato de Vasconcelos");
		correntista1.setConta(conta1);

		correntistaRepository.save(correntista);
		correntistaRepository.save(correntista1);
	}
}
