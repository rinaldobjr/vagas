package com.pasquali.vagas.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.pasquali.vagas.domain.Nivel;
import com.pasquali.vagas.dto.NivelDTO;
import com.pasquali.vagas.services.NivelService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/api/nivel")
public class NivelResource {
	
	@Autowired
	private NivelService nivelService;
	
	// FindById
	@ApiOperation(value = "Get Cargo by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Nivel objeto = nivelService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	// ListAll
	@ApiOperation(value = "Get Cargo Grid List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @GetMapping(value = "/listar", produces = "application/json")
	public ResponseEntity<List<NivelDTO>> listando() {
		List<Nivel> lista = nivelService.listar();
		List<NivelDTO> listaDTO = lista.stream().map(obj -> new NivelDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	// Insert
	@ApiOperation(value = "Save New Nivel")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping(produces = "application/json")
	public ResponseEntity<Void> inserir(@Valid @RequestBody NivelDTO objDto) {
		Nivel obj = nivelService.fromDTO(objDto);
		obj = nivelService.inserindo(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
	// Update
	@ApiOperation(value = "Update Nivel")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@PutMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<Void> alterar(@RequestBody Nivel obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = nivelService.alterando(obj);
		return ResponseEntity.noContent().build();
	}

	// Delete
	@ApiOperation(value = "Delete Nivel")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		nivelService.deletando(id);
		return ResponseEntity.noContent().build();
	}

	
	// Page
	@ApiOperation(value = "Paging of Nivel")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(value="/page",produces = "application/json")
	public ResponseEntity<Page<NivelDTO>> paginacao(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nomeNivel") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Nivel> lista = nivelService.paginacao(page, linesPerPage, orderBy, direction);
		Page<NivelDTO> listaDTO = lista.map(obj -> new NivelDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
}
