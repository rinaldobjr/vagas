package com.pasquali.vagas.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pasquali.vagas.domain.Contrato;
import com.pasquali.vagas.dto.ContratoDTO;
import com.pasquali.vagas.services.ContratoService;

@RestController
@RequestMapping(value="/contrato")
public class ContratoResource {
	
	@Autowired
	private ContratoService contratoService;

	// FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Contrato objeto = contratoService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	// ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<ContratoDTO>> listando() {
		List<Contrato> lista = contratoService.listar();
		List<ContratoDTO> listaDTO = lista.stream().map(obj -> new ContratoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	// Insert
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody ContratoDTO objDto) {
		Contrato obj = contratoService.fromDTO(objDto);
		obj = contratoService.inserindo(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
	// Update
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody Contrato obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = contratoService.alterando(obj);
		return ResponseEntity.noContent().build();
	}

	// Delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		contratoService.deletando(id);
		return ResponseEntity.noContent().build();
	}

	// Page
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ContratoDTO>> paginacao(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nomeContrato") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Contrato> lista = contratoService.paginacao(page, linesPerPage, orderBy, direction);
		Page<ContratoDTO> listaDTO = lista.map(obj -> new ContratoDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}

}
