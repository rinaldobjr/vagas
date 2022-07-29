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
import com.pasquali.vagas.dto.CidadeDTO;
import com.pasquali.vagas.repositories.CidadeRepository;
import com.pasquali.vagas.services.exception.DataIntegrityException;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	public Cidade buscar(Integer id) {
		Optional<Cidade> obj = cidadeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}

	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}
	//+++
	public Cidade inserindo(Cidade obj) {
		obj.setId(null);
		return cidadeRepository.save(obj);
	}
	//+++
	public Cidade alterando(Cidade obj) {
		Cidade newObj = buscar(obj.getId());
		alterandoDados(newObj, obj);
		return cidadeRepository.save(obj);
	}

	public void deletando(Integer id) {
		buscar(id);
		try {
			cidadeRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Área que possui dependência em outra Tabela!");
		}
	}

	public Page<Cidade> paginacao(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pages = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return cidadeRepository.findAll(pages);
	}

	public Cidade fromDTO(CidadeDTO objDto) {
		//return new Cidade(objDto.getId(), objDto.getNome(), objDto.getAtivo(), objDto.getEstado());
		return new Cidade(null, null, null, null);
	}

	private void alterandoDados(Cidade newObj, Cidade obj) {
		//newObj.setEstado(obj.getEstado());
		newObj.setNome(obj.getNome());
		newObj.setAtivo(obj.getAtivo());
	}
}
