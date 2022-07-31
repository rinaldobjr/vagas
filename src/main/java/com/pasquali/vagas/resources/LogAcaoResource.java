package com.pasquali.vagas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pasquali.vagas.domain.LogAcao;
import com.pasquali.vagas.dto.LogAcaoDTO;
import com.pasquali.vagas.services.LogAcaoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/logacao")
public class LogAcaoResource {

	@Autowired
	private LogAcaoService logAcaoService;

	// FindById
	@ApiOperation(value = "Get Log Acao by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		LogAcao objeto = logAcaoService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}

	// ListAll
	@ApiOperation(value = "Get Log Acao Grid List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @GetMapping(value = "/listar", produces = "application/json")
	public ResponseEntity<List<LogAcao>> listando() {
		List<LogAcao> lista = logAcaoService.listar();
		return ResponseEntity.ok().body(lista);
	}
	
	// Page
	@ApiOperation(value = "Paging of Log Acao")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(value="/page",produces = "application/json")
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
