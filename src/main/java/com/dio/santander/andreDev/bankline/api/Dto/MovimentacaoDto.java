package com.dio.santander.andreDev.bankline.api.Dto;

import com.dio.santander.andreDev.bankline.api.model.Movimentacao;
import com.dio.santander.andreDev.bankline.api.model.MovimentacaoTipo;

public class MovimentacaoDto {

	private String descricao;
	private Double valor;
	private MovimentacaoTipo tipo;
	private Integer idConta;
	
	

	public MovimentacaoDto(Movimentacao movimentacao) {
		this.descricao = movimentacao.getDescricao();
		this.valor = movimentacao.getValor();
		this.tipo = movimentacao.getTipo();
		this.idConta= movimentacao.getIdConta();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public MovimentacaoTipo getTipo() {
		return tipo;
	}

	public void setTipo(MovimentacaoTipo tipo) {
		this.tipo = tipo;
	}

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

}
