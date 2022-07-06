package com.pasquali.vagas;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pasquali.vagas.domain.Cargo;
import com.pasquali.vagas.domain.Cidade;
import com.pasquali.vagas.domain.Estado;
import com.pasquali.vagas.repositories.CargoRepository;
import com.pasquali.vagas.repositories.CidadeRepository;
import com.pasquali.vagas.repositories.EstadoRepository;

@SpringBootApplication
public class VagasApplication implements CommandLineRunner{
	
	private CargoRepository cargoRepository;
	private CidadeRepository cidadeRepository;
	private EstadoRepository estadoRepository;
	
	public VagasApplication(CargoRepository cargoRepository, 
			CidadeRepository cidadeRepository, 
			EstadoRepository estadoRepository) {
		this.cargoRepository = cargoRepository;
		this.cidadeRepository = cidadeRepository;
		this.estadoRepository = estadoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(VagasApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
		Cargo car1 = new Cargo(null, "Arquiteto de Infraestrutura", 1);
		Cargo car2 = new Cargo(null, "Consultor Técnico Oracle", 1);
		Cargo car3 = new Cargo(null, "Técnico De Suporte Remoto", 1);
		
		cargoRepository.saveAll(Arrays.asList(car1,car2,car3));
		
		Estado est1 = new Estado(null, "São Paulo", 1);
		Estado est2 = new Estado(null, "Minas Gerais", 1);
		Estado est3 = new Estado(null, "Rio de Janeiro", 1);
		
		Cidade c1 = new Cidade(null, "Jundiai", 1, est1);
		Cidade c2 = new Cidade(null, "São Paulo", 1, est1);
		Cidade c3 = new Cidade(null, "Uberlândia", 1, est2);
		Cidade c4 = new Cidade(null, "Guanabara", 1, est3);
		
		est1.getCidades().addAll(Arrays.asList(c1,c2));
		est2.getCidades().addAll(Arrays.asList(c3));
		est3.getCidades().addAll(Arrays.asList(c4));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2,est3));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
	}
}
