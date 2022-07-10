package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Cargo;
import com.pasquali.vagas.domain.Empresa;
import com.pasquali.vagas.repositories.EmpresaRepository;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa buscar(Integer id) {
		Optional<Empresa> obj = empresaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cargo.class.getName()));
	}
	
	public List<Empresa> listar() {
		List<Empresa> listagem = empresaRepository.findAll();
		return listagem;
	}
}
