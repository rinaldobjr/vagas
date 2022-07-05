package com.pasquali.vagas;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pasquali.vagas.domain.Cargo;
import com.pasquali.vagas.repositories.CargoRepository;

@SpringBootApplication
public class VagasApplication implements CommandLineRunner{
	
	@Autowired
	private CargoRepository cargoRepository;

	public static void main(String[] args) {
		SpringApplication.run(VagasApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
		Cargo car1 = new Cargo(null, "Arquiteto de Infraestrutura", 1);
		Cargo car2 = new Cargo(null, "Consultor Técnico Oracle", 1);
		Cargo car3 = new Cargo(null, "Técnico De Suporte Remoto", 1);
		
		cargoRepository.saveAll(Arrays.asList(car1,car2,car3));
	}
}
