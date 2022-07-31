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

import com.pasquali.vagas.domain.Cargo;
import com.pasquali.vagas.domain.Usuario;
import com.pasquali.vagas.dto.CargoDTO;
import com.pasquali.vagas.dto.UsuarioDTO;
import com.pasquali.vagas.services.UsuarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/api/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	// FindById
	@ApiOperation(value = "Get Usuario by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Usuario objeto = usuarioService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	// ListAll
	@ApiOperation(value = "Get Usuario Grid List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @GetMapping(value = "/listar", produces = "application/json")
	public ResponseEntity<List<UsuarioDTO>> listando() {
		List<Usuario> lista = usuarioService.listar();
		List<UsuarioDTO> listaDTO = lista.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}

	/*
	
	// Insert
	@ApiOperation(value = "Save New Cargo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping(produces = "application/json")
	public ResponseEntity<Void> inserir(@Valid @RequestBody CargoDTO objDto) {
		Cargo obj = cargoService.fromDTO(objDto);
		obj = cargoService.inserindo(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
	// Update
	@ApiOperation(value = "Update Cargo")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@PutMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<Void> alterar(@RequestBody Cargo obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = cargoService.alterando(obj);
		return ResponseEntity.noContent().build();
	}

	// Delete
	@ApiOperation(value = "Delete Cargo")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		cargoService.deletando(id);
		return ResponseEntity.noContent().build();
	}

	// Page
	@ApiOperation(value = "Paging of Cargo")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(value="/page",produces = "application/json")
	public ResponseEntity<Page<CargoDTO>> paginacao(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nomeCargo") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Cargo> lista = cargoService.paginacao(page, linesPerPage, orderBy, direction);
		Page<CargoDTO> listaDTO = lista.map(obj -> new CargoDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
	 */

}
