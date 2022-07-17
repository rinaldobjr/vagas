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

import com.pasquali.vagas.domain.LocalTrabalho;
import com.pasquali.vagas.dto.LocalTrabalhoDTO;
import com.pasquali.vagas.services.LocalTrabalhoService;

@RestController
@RequestMapping(value="/localtrabalho")
public class LocalTrabalhoResource {
	
	@Autowired
	private LocalTrabalhoService localTrabalhoService;
	
	// FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		LocalTrabalho objeto = localTrabalhoService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	// ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<LocalTrabalhoDTO>> listando() {
		List<LocalTrabalho> lista = localTrabalhoService.listar();
		List<LocalTrabalhoDTO> listaDTO = lista.stream().map(obj -> new LocalTrabalhoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	// Insert
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody LocalTrabalhoDTO objDto) {
		LocalTrabalho obj = localTrabalhoService.fromDTO(objDto);
		obj = localTrabalhoService.inserindo(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
	// Update
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody LocalTrabalho obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = localTrabalhoService.alterando(obj);
		return ResponseEntity.noContent().build();
	}

	// Delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		localTrabalhoService.deletando(id);
		return ResponseEntity.noContent().build();
	}

	// Page
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<LocalTrabalhoDTO>> paginacao(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nomeLocal") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<LocalTrabalho> lista = localTrabalhoService.paginacao(page, linesPerPage, orderBy, direction);
		Page<LocalTrabalhoDTO> listaDTO = lista.map(obj -> new LocalTrabalhoDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
	

}
