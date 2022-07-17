package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Cidade;
import com.pasquali.vagas.domain.Nivel;
import com.pasquali.vagas.dto.NivelDTO;
import com.pasquali.vagas.repositories.NivelRepository;
import com.pasquali.vagas.services.exception.DataIntegrityException;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;


@Service
public class NivelService {
	
	@Autowired
	private NivelRepository nivelRepository;
	
	public Nivel buscar(Integer id) {
		Optional<Nivel> obj = nivelRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}
	
	public List<Nivel> listar() {
		return nivelRepository.findAll();
	}

	public Nivel inserindo(Nivel obj) {
		obj.setId(null);
		return nivelRepository.save(obj);
	}

	public Nivel alterando(Nivel obj) {
		Nivel newObj = buscar(obj.getId());
		alterandoDados(newObj, obj);
		return nivelRepository.save(obj); 
	}
	
	public void deletando(Integer id) {
		buscar(id);
		try {
			nivelRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Área que possui dependência em outra Tabela!");
		}
	}
	
	public Page<Nivel> paginacao(Integer page, Integer linesPerPage, String orderBy , String direction) {
		PageRequest pages = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return nivelRepository.findAll(pages);
	}
	
	public Nivel fromDTO(NivelDTO objDto) {
		return new Nivel(objDto.getId(), objDto.getNomeNivel(), objDto.getAtivo() );
	}
	
	private void alterandoDados(Nivel newObj, Nivel obj) {
		newObj.setNomeNivel(obj.getNomeNivel());
		newObj.setAtivo(obj.getAtivo());
	}
	
}
