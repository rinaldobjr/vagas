package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.LogAcao;
import com.pasquali.vagas.repositories.LogAcaoRepository;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;


@Service
public class LogAcaoService {
	
	@Autowired
	private LogAcaoRepository logAcaoRepository;
	
	public LogAcao buscar(Integer id) {
		Optional<LogAcao> obj = logAcaoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + LogAcao.class.getName()));
	}
	
	public List<LogAcao> listar() {
		return logAcaoRepository.findAll();
	}
	
	public LogAcao inserindo(LogAcao obj) {
		return logAcaoRepository.save(obj);
	}
	
	public Page<LogAcao> paginacao(Integer page, Integer linesPerPage, String orderBy , String direction, 
			Integer tipoAcao, String tabela, Integer usuario) {
		PageRequest pages = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		if (tipoAcao != null) {
			return logAcaoRepository.findByTipoAcaoOrderByDataDesc(tipoAcao, pages);
		} else if (tabela != null) {
			return logAcaoRepository.findByTabelaOrderByDataDescHoraDesc(tabela, pages);
		} else if (usuario != null) {
			return logAcaoRepository.findByUsuarioOrderByDataDesc(usuario, pages);
		}
		return logAcaoRepository.findAll(pages);
	}
	
}