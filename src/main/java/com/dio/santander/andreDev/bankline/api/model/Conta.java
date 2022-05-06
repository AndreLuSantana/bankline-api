package com.dio.santander.andreDev.bankline.api.model;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Conta {

	private Long numero;
	private Double saldo;

	public Conta() {

		this.numero = new Date().getTime();
		this.saldo = 0.0;
	}
	
	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
