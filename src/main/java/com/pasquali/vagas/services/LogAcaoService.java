package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.LogAcao;
import com.pasquali.vagas.repositories.LogAcaoRepository;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;


@Service
public class LogAcaoService {
	
	@Autowired
	private LogAcaoRepository logAcaoRepository;
	
	public LogAcao buscar(Integer id) {
		Optional<LogAcao> obj = logAcaoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + LogAcao.class.getName()));
	}
	
	public List<LogAcao> listar() {
		List<LogAcao> listagem = logAcaoRepository.findAll();
		return listagem;
	}
	
}