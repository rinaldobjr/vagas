package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Contrato;
import com.pasquali.vagas.repositories.ContratoRepository;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;


@Service
public class ContratoService {
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	public Contrato buscar(Integer id) {
		Optional<Contrato> obj = contratoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Contrato.class.getName()));
	}
	
	public List<Contrato> listar() {
		List<Contrato> listagem = contratoRepository.findAll();
		return listagem;
	}

}
