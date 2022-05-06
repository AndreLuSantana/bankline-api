package com.dio.santander.andreDev.bankline.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.santander.andreDev.bankline.api.model.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer>{

	
}
