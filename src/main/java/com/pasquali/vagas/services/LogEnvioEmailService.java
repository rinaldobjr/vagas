package com.pasquali.vagas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.LogEnvioEmail;
import com.pasquali.vagas.repositories.LogEnvioEmailRepository;

@Service
public class LogEnvioEmailService {

	@Autowired
	private LogEnvioEmailRepository logEnvioEmailRepository;
	
	public List<LogEnvioEmail> listar() {
		List<LogEnvioEmail> listagem = logEnvioEmailRepository.findAll();
		return listagem;
	}
}
