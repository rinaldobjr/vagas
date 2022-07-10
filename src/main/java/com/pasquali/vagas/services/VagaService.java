package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Vaga;
import com.pasquali.vagas.repositories.VagaRepository;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;

@Service
public class VagaService {

	@Autowired
	private VagaRepository vagaRepository;

	public Vaga buscar(Integer id) {
		Optional<Vaga> obj = vagaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Vaga.class.getName()));
	}

	public List<Vaga> listar() {
		List<Vaga> listagem = vagaRepository.findAll();
		return listagem;
	}

}
