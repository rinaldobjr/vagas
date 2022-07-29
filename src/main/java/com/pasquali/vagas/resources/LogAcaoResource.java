package com.pasquali.vagas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pasquali.vagas.domain.LogAcao;
import com.pasquali.vagas.dto.LogAcaoDTO;
import com.pasquali.vagas.services.LogAcaoService;

@RestController
@RequestMapping(value = "/logacao")
public class LogAcaoResource {

	@Autowired
	private LogAcaoService logAcaoService;

	// FindById
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		LogAcao objeto = logAcaoService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}

	// ListAll
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<LogAcao>> listando() {
		List<LogAcao> lista = logAcaoService.listar();
		return ResponseEntity.ok().body(lista);
	}
	
	// Page
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<LogAcaoDTO>> paginacao(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "tabela") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "tipoAcao", defaultValue = "1") Integer tipoAcao,
			@RequestParam(value = "tabela", defaultValue = "") String tabela,
			@RequestParam(value = "usuario", defaultValue = "") Integer usuario
			) {
		Page<LogAcao> lista = logAcaoService.paginacao(page, linesPerPage, orderBy, direction, tipoAcao, tabela, usuario);
		Page<LogAcaoDTO> listaDTO = lista.map(obj -> new LogAcaoDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
}
