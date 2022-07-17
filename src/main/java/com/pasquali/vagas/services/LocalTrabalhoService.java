package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.LocalTrabalho;
import com.pasquali.vagas.dto.LocalTrabalhoDTO;
import com.pasquali.vagas.repositories.LocalTrabalhoRepository;
import com.pasquali.vagas.services.exception.DataIntegrityException;
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
		return localTrabalhoRepository.findAll();
	}
	
	public LocalTrabalho inserindo(LocalTrabalho obj) {
		obj.setId(null);
		return localTrabalhoRepository.save(obj);
	}

	public LocalTrabalho alterando(LocalTrabalho obj) {
		LocalTrabalho newObj = buscar(obj.getId());
		alterandoDados(newObj, obj);
		return localTrabalhoRepository.save(obj); 
	}
	
	public void deletando(Integer id) {
		buscar(id);
		try {
			localTrabalhoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Área que possui dependência em outra Tabela!");
		}
	}
	
	public Page<LocalTrabalho> paginacao(Integer page, Integer linesPerPage, String orderBy , String direction) {
		PageRequest pages = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return localTrabalhoRepository.findAll(pages);
	}
	
	public LocalTrabalho fromDTO(LocalTrabalhoDTO objDto) {
		return new LocalTrabalho(objDto.getId(), objDto.getNomeLocal(), objDto.getAtivo() );
	}
	
	private void alterandoDados(LocalTrabalho newObj, LocalTrabalho obj) {
		newObj.setNomeLocal(obj.getNomeLocal());
		newObj.setAtivo(obj.getAtivo());
	}
	
}
