package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Cargo;
import com.pasquali.vagas.repositories.CargoRepository;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;


@Service
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public Cargo buscar(Integer id) {
		Optional<Cargo> obj = cargoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cargo.class.getName()));
	}
	
	public List<Cargo> listar() {
		List<Cargo> listagem = cargoRepository.findAll();
		System.out.println(listagem);
		return listagem;
	}

}
