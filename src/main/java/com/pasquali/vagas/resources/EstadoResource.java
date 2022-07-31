package com.pasquali.vagas.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pasquali.vagas.domain.Estado;
import com.pasquali.vagas.dto.EstadoDTO;
import com.pasquali.vagas.services.EstadoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/api/estado")
public class EstadoResource {
	
	@Autowired
	private EstadoService estadoService;
	
	//FindById
	@ApiOperation(value = "Get Estado by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Estado objeto = estadoService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	//ListAll
	@ApiOperation(value = "Get Estado Grid List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @GetMapping(value = "/listar", produces = "application/json")
	public ResponseEntity<List<Estado>> listando() {
		List<Estado> lista = estadoService.listar();
		return ResponseEntity.ok().body(lista);
	}
	
	//Insert
	@ApiOperation(value = "Save New Estado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping(produces = "application/json")
	public ResponseEntity<Void> inserir(@Valid @RequestBody EstadoDTO objDto) {
		Estado obj = estadoService.fromDTO(objDto);
		obj = estadoService.inserindo(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// Update
	@ApiOperation(value = "Update Estado")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@PutMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<Void> alterar(@RequestBody Estado obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = estadoService.alterando(obj);
		return ResponseEntity.noContent().build();
	}
		
	//Delete
	@ApiOperation(value = "Delete Estado")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		estadoService.deletando(id);
		return ResponseEntity.noContent().build();
	}
	
	//Page
	@ApiOperation(value = "Paging of Estado")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(value="/page",produces = "application/json")
	public ResponseEntity<Page<EstadoDTO>> paginacao(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Estado> lista = estadoService.paginacao(page, linesPerPage, orderBy, direction);
		Page<EstadoDTO> listaDTO = lista.map(obj -> new EstadoDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
	
}
