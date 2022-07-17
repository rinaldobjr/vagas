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

import com.pasquali.vagas.domain.VagaStatus;
import com.pasquali.vagas.dto.VagaStatusDTO;
import com.pasquali.vagas.services.VagaStatusService;

@RestController
@RequestMapping(value="/vagastatus")
public class VagaStatusResource {
	
	@Autowired
	private VagaStatusService vagaStatusService;
	
	// FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		VagaStatus objeto = vagaStatusService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	// ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<VagaStatusDTO>> listando() {
		List<VagaStatus> lista = vagaStatusService.listar();
		List<VagaStatusDTO> listaDTO =lista.stream().map(obj -> new VagaStatusDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	// Insert
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody VagaStatusDTO objDto) {
		VagaStatus obj = vagaStatusService.fromDTO(objDto);
		obj = vagaStatusService.inserindo(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// Update
	@RequestMapping(value="/{id}", method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Void> alterar(@RequestBody VagaStatus obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = vagaStatusService.alterando(obj);
		return ResponseEntity.noContent().build();
	}
	
	// Delete
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		vagaStatusService.deletando(id);
		return ResponseEntity.noContent().build();
	}
	
	// Page
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<VagaStatusDTO>> paginacao(
			@RequestParam(value="page",defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage",defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value="orderBy",defaultValue = "statusNome") String orderBy , 
			@RequestParam(value="direction",defaultValue = "ASC") String direction) {
		Page<VagaStatus> lista = vagaStatusService.paginacao(page,linesPerPage,orderBy,direction);
		Page<VagaStatusDTO> listaDTO = lista.map(obj -> new VagaStatusDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
}
