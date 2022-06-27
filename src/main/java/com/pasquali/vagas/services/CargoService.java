package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Cargo;
import com.pasquali.vagas.repositories.CargoRepository;


@Service
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public Cargo buscar(Integer id) {
		Optional<Cargo> objeto = cargoRepository.findById(id);
		return objeto.orElse(null);
	}
	
	public List<Cargo> listar() {
		List<Cargo> listagem = cargoRepository.findAll();
		System.out.println(listagem);
		return listagem;
	}

}
