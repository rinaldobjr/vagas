package com.pasquali.vagas.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pasquali.vagas.domain.Area;
import com.pasquali.vagas.dto.AreaDTO;
import com.pasquali.vagas.services.AreaService;

@RestController
@RequestMapping(value="/area")
public class AreaResource {
	
	@Autowired
	private AreaService areaService;
	
	// FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Area> findById(@PathVariable Integer id) {
		Area objeto = areaService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	// ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<AreaDTO>> listando() {
		List<Area> lista = areaService.listar();
		List<AreaDTO> listaDTO = lista.stream().map(obj -> new AreaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	// Insert
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody AreaDTO objDto) {
		Area obj = areaService.fromDTO(objDto);
		obj = areaService.inserindo(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// Update
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alterar(@RequestBody Area obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = areaService.alterando(obj);
		return ResponseEntity.noContent().build();
	}
	
	// Delete
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		areaService.deletando(id);
		return ResponseEntity.noContent().build();
	}
	
	// Page
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<AreaDTO>> paginacao(
			@RequestParam(value="page",defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage",defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value="orderBy",defaultValue = "nomeArea") String orderBy , 
			@RequestParam(value="direction",defaultValue = "ASC") String direction) {
		Page<Area> lista = areaService.paginacao(page,linesPerPage,orderBy,direction);
		Page<AreaDTO> listaDTO = lista.map(obj -> new AreaDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}

}
