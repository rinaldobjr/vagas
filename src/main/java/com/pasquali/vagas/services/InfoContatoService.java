package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.InfoContato;
import com.pasquali.vagas.repositories.InfoContatoRepository;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;


@Service
public class InfoContatoService {
	
	@Autowired
	private InfoContatoRepository infoContatoRepository;
	
	public InfoContato buscar(Integer id) {
		Optional<InfoContato> obj = infoContatoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + InfoContato.class.getName()));
	}
	
	public List<InfoContato> listar() {
		List<InfoContato> listagem = infoContatoRepository.findAll();
		return listagem;
	}

}
