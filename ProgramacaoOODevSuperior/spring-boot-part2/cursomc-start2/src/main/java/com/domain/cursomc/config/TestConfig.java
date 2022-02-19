package com.domain.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.domain.cursomc.services.DBService;

@Configuration
@Profile("test") //especifica que todos os beans dessa classe vão ser ativos apenas ness eperfil
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		dbService.instanteateTestDatabase();
		
		return true;
	}

}
