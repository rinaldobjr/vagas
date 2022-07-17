package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Cargo;
import com.pasquali.vagas.dto.CargoDTO;
import com.pasquali.vagas.repositories.CargoRepository;
import com.pasquali.vagas.services.exception.DataIntegrityException;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;


@Service
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public Cargo buscar(Integer id) {
		Optional<Cargo> obj = cargoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cargo.class.getName()));
	}
	
	public List<Cargo> listar() {
		return cargoRepository.findAll();
	}

	public Cargo inserindo(Cargo obj) {
		obj.setId(null);
		return cargoRepository.save(obj);
	}

	public Cargo alterando(Cargo obj) {
		Cargo newObj = buscar(obj.getId());
		alterandoDados(newObj, obj);
		return cargoRepository.save(obj); 
	}
	
	public void deletando(Integer id) {
		buscar(id);
		try {
			cargoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Área que possui dependência em outra Tabela!");
		}
	}
	
	public Page<Cargo> paginacao(Integer page, Integer linesPerPage, String orderBy , String direction) {
		PageRequest pages = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return cargoRepository.findAll(pages);
	}
	
	public Cargo fromDTO(CargoDTO objDto) {
		return new Cargo(objDto.getId(), objDto.getNomeCargo(), objDto.getAtivo() );
	}
	
	private void alterandoDados(Cargo newObj, Cargo obj) {
		newObj.setNomeCargo(obj.getNomeCargo());
		newObj.setAtivo(obj.getAtivo());
	}
}
