package com.pasquali.vagas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.repositories.VagaRepository;

@Service
public class VagaService {

	@Autowired
	private VagaRepository vagaRepository;
}
