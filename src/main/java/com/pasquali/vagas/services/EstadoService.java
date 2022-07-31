package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Estado;
import com.pasquali.vagas.dto.EstadoDTO;
import com.pasquali.vagas.repositories.EstadoRepository;
import com.pasquali.vagas.services.exception.DataIntegrityException;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public Estado buscar(Integer id) {
		Optional<Estado> obj = estadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}

	public List<Estado> listar() {
		return estadoRepository.findAll();
	}

	public Estado inserindo(Estado obj) {
		obj.setId(null);
		return estadoRepository.save(obj);
	}

	public Estado alterando(Estado obj) {
		Estado newObj = buscar(obj.getId());
		alterandoDados(newObj, obj);
		return estadoRepository.save(obj);
	}

	public void deletando(Integer id) {
		buscar(id);
		try {
			estadoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Área que possui dependência em outra Tabela!");
		}
	}

	public Page<Estado> paginacao(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pages = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return estadoRepository.findAll(pages);
	}

	public Estado fromDTO(EstadoDTO objDto) {
		return new Estado(objDto.getId(), objDto.getNome(), objDto.getSigla(), objDto.getAtivo());
	}

	private void alterandoDados(Estado newObj, Estado obj) {
		newObj.setNome(obj.getNome());
		newObj.setSigla(obj.getSigla());
		newObj.setAtivo(obj.getAtivo());
	}

}
