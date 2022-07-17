package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Contrato;
import com.pasquali.vagas.dto.ContratoDTO;
import com.pasquali.vagas.repositories.ContratoRepository;
import com.pasquali.vagas.services.exception.DataIntegrityException;
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
		return contratoRepository.findAll();
	}

	public Contrato inserindo(Contrato obj) {
		obj.setId(null);
		return contratoRepository.save(obj);
	}

	public Contrato alterando(Contrato obj) {
		Contrato newObj = buscar(obj.getId());
		alterandoDados(newObj, obj);
		return contratoRepository.save(obj); 
	}
	
	public void deletando(Integer id) {
		buscar(id);
		try {
			contratoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Área que possui dependência em outra Tabela!");
		}
	}
	
	public Page<Contrato> paginacao(Integer page, Integer linesPerPage, String orderBy , String direction) {
		PageRequest pages = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return contratoRepository.findAll(pages);
	}
	
	public Contrato fromDTO(ContratoDTO objDto) {
		return new Contrato(objDto.getId(), objDto.getNomeContrato(), objDto.getAtivo() );
	}
	
	private void alterandoDados(Contrato newObj, Contrato obj) {
		newObj.setNomeContrato(obj.getNomeContrato());
		newObj.setAtivo(obj.getAtivo());
	}
}
