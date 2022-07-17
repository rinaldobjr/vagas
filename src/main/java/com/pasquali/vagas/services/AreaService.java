package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Area;
import com.pasquali.vagas.dto.AreaDTO;
import com.pasquali.vagas.repositories.AreaRepository;
import com.pasquali.vagas.services.exception.DataIntegrityException;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;


@Service
public class AreaService {
	
	@Autowired
	private AreaRepository areaRepository;
	
	public Area buscar(Integer id) {
		Optional<Area> obj = areaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Area.class.getName()));
	}
	
	public List<Area> listar() {
		return areaRepository.findAll();
	}
	
	public Area inserindo(Area obj) {
		obj.setId(null);
		return areaRepository.save(obj);
	}
	
	public Area alterando(Area obj) {
		Area newObj = buscar(obj.getId());
		alterandoDados(newObj, obj);
		return areaRepository.save(obj); 
	}
	
	public void deletando(Integer id) {
		buscar(id);
		try {
			areaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Área que possui dependência em outra Tabela!");
		}
	}
	
	public Page<Area> paginacao(Integer page, Integer linesPerPage, String orderBy , String direction) {
		PageRequest pages = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return areaRepository.findAll(pages);
	}
	
	public Area fromDTO(AreaDTO objDto) {
		return new Area(objDto.getId(), objDto.getNomeArea(), objDto.getNome(), objDto.getAtivo() );
	}
	
	private void alterandoDados(Area newObj, Area obj) {
		newObj.setNomeArea(obj.getNomeArea());
		newObj.setNome(obj.getNome());
		newObj.setAtivo(obj.getAtivo());
	}
}
