package com.dio.santander.andreDev.bankline.api.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.andreDev.bankline.api.Dto.MovimentacaoDto;
import com.dio.santander.andreDev.bankline.api.model.Correntista;
import com.dio.santander.andreDev.bankline.api.model.Movimentacao;
import com.dio.santander.andreDev.bankline.api.model.MovimentacaoTipo;
import com.dio.santander.andreDev.bankline.api.repositories.CorrentistaRepository;
import com.dio.santander.andreDev.bankline.api.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@Autowired
	private CorrentistaRepository correntistaRepository;

	public List<MovimentacaoDto> findAll() {

		List<Movimentacao> movimentacoes = movimentacaoRepository.findAll();

		return movimentacoes.stream().map(x -> new MovimentacaoDto(x)).collect(Collectors.toList());
	}

	public MovimentacaoDto save(Movimentacao obj) {

		Correntista correntista = correntistaRepository.findById(obj.getIdConta()).orElse(null);

		if (correntista != null) {
			correntista.getConta().setSaldo(calculaSaldo(obj, correntista));
		}
		
		correntistaRepository.save(correntista);

		obj.setDataHora(LocalDateTime.now());

		Movimentacao movimentacao = movimentacaoRepository.save(obj);

		return new MovimentacaoDto(movimentacao);
	}

	public Double calculaSaldo(Movimentacao objM, Correntista objC) {

		Double saldo = objC.getConta().getSaldo();
		Double valor = objM.getValor();
		Double saldoTotal;

		if (objM.getTipo() == MovimentacaoTipo.DESPESA) {
			valor *= -1;
		}
		
		saldoTotal = saldo + valor;
		
		if(saldoTotal < 0) {
			saldoTotal = saldo;
		}
		return saldoTotal;
	}
}
