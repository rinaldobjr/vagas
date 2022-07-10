package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Vaga;
import com.pasquali.vagas.domain.VagaStatus;
import com.pasquali.vagas.repositories.VagaStatusRepository;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;

@Service
public class VagaStatusService {

	@Autowired
	private VagaStatusRepository vagaStatusRepository;
	
	public VagaStatus buscar(Integer id) {
		Optional<VagaStatus> obj = vagaStatusRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Vaga.class.getName()));
	}

	public List<VagaStatus> listar() {
		List<VagaStatus> listagem = vagaStatusRepository.findAll();
		return listagem;
	}

}
