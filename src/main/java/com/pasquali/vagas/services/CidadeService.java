package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Cidade;
import com.pasquali.vagas.repositories.CidadeRepository;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;


@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade buscar(Integer id) {
		Optional<Cidade> obj = cidadeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}
	
	public List<Cidade> listar() {
		List<Cidade> listagem = cidadeRepository.findAll();
		return listagem;
	}

}
