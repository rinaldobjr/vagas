package com.pasquali.vagas.resources;

import java.net.URI;
import java.util.List;

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

import com.pasquali.vagas.domain.Cidade;
import com.pasquali.vagas.dto.CidadeDTO;
import com.pasquali.vagas.services.CidadeService;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeResource {

	@Autowired
	private CidadeService cidadeService;

	// private SessionFactory sessionFactory;

	// FindById
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Cidade objeto = cidadeService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}

	// ListAll
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Cidade>> listando() {
		List<Cidade> lista = cidadeService.listar();
		return ResponseEntity.ok().body(lista);
	}

	// Insert
	//@PostMapping(value="/rest/account/json", consumes={"application/json"})
	@RequestMapping(method = RequestMethod.POST, consumes={"application/json"})
	public ResponseEntity<Void> inserir(@Valid @RequestBody CidadeDTO objDto) {
		Cidade obj = cidadeService.fromDTO(objDto);
		obj = cidadeService.inserindo(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// Update
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)	public ResponseEntity<Void> alterar(@RequestBody Cidade obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = cidadeService.alterando(obj);
		return ResponseEntity.noContent().build();
	}

	// Delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		cidadeService.deletando(id);
		return ResponseEntity.noContent().build();
	}

	// Page
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CidadeDTO>> paginacao(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Cidade> lista = cidadeService.paginacao(page, linesPerPage, orderBy, direction);
		Page<CidadeDTO> listaDTO = lista.map(obj -> new CidadeDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}

}
