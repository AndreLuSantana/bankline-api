package com.dio.santander.andreDev.bankline.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dio.santander.andreDev.bankline.api.services.config.DBService;

@Configuration
@Profile("teste")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}
	
}
