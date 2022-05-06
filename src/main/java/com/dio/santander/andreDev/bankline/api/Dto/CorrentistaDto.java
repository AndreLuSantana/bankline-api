package com.dio.santander.andreDev.bankline.api.Dto;

import com.dio.santander.andreDev.bankline.api.model.Conta;
import com.dio.santander.andreDev.bankline.api.model.Correntista;

public class CorrentistaDto {

	private Integer id;
	private String cpf;
	private String nome;
	
	private Conta conta;

	public CorrentistaDto() {

	}
	
	public CorrentistaDto(Correntista correntista) {
		this.id = correntista.getId();
		this.cpf = correntista.getCpf();
		this.nome = correntista.getNome();
		this.conta = correntista.getConta();
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Integer getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
