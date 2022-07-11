package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Area;
import com.pasquali.vagas.repositories.AreaRepository;
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
		List<Area> listagem = areaRepository.findAll();
		return listagem;
	}
	
	public Area inserir(Area obj) {
		obj.setId(null);
		return areaRepository.save(obj);
	}

}
