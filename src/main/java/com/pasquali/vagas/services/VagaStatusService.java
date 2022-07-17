package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Vaga;
import com.pasquali.vagas.domain.VagaStatus;
import com.pasquali.vagas.dto.VagaStatusDTO;
import com.pasquali.vagas.repositories.VagaStatusRepository;
import com.pasquali.vagas.services.exception.DataIntegrityException;
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
		return vagaStatusRepository.findAll();
	}

	public VagaStatus inserindo(VagaStatus obj) {
		obj.setId(null);
		return vagaStatusRepository.save(obj);
	}
	
	public VagaStatus alterando(VagaStatus obj) {
		VagaStatus newObj = buscar(obj.getId());
		alterandoDados(newObj, obj);
		return vagaStatusRepository.save(obj); 
	}
	
	public void deletando(Integer id) {
		buscar(id);
		try {
			vagaStatusRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Área que possui dependência em outra Tabela!");
		}
	}
	
	public Page<VagaStatus> paginacao(Integer page, Integer linesPerPage, String orderBy , String direction) {
		PageRequest pages = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return vagaStatusRepository.findAll(pages);
	}
	
	public VagaStatus fromDTO(VagaStatusDTO objDto) {
		return new VagaStatus(objDto.getId(), objDto.getStatusNome(), objDto.getAtivo());
	}
	
	private void alterandoDados(VagaStatus newObj, VagaStatus obj) {
		newObj.setStatusNome(obj.getStatusNome());
		newObj.setAtivo(obj.getAtivo());
	}
}
