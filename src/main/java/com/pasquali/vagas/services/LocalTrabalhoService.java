package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.LocalTrabalho;
import com.pasquali.vagas.repositories.LocalTrabalhoRepository;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;


@Service
public class LocalTrabalhoService {
	
	@Autowired
	private LocalTrabalhoRepository localTrabalhoRepository;
	
	public LocalTrabalho buscar(Integer id) {
		Optional<LocalTrabalho> obj = localTrabalhoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + LocalTrabalho.class.getName()));
	}
	
	public List<LocalTrabalho> listar() {
		List<LocalTrabalho> listagem = localTrabalhoRepository.findAll();
		return listagem;
	}

}
