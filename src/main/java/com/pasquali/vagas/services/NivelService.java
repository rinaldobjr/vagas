package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Cidade;
import com.pasquali.vagas.domain.Nivel;
import com.pasquali.vagas.repositories.NivelRepository;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;


@Service
public class NivelService {
	
	@Autowired
	private NivelRepository nivelRepository;
	
	public Nivel buscar(Integer id) {
		Optional<Nivel> obj = nivelRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}
	
	public List<Nivel> listar() {
		List<Nivel> listagem = nivelRepository.findAll();
		return listagem;
	}

}
