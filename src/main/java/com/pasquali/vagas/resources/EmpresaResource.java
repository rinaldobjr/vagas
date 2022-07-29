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

import com.pasquali.vagas.EmpresaService;
import com.pasquali.vagas.domain.Empresa;
import com.pasquali.vagas.dto.EmpresaDTO;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaResource {

	@Autowired
	private EmpresaService empresaService;

	// FindById
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Empresa objeto = empresaService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}

	// ListAll
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Empresa>> listando() {
		List<Empresa> lista = empresaService.listar();
		return ResponseEntity.ok().body(lista);
	}

	// Insert
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody EmpresaDTO objDto) {
		Empresa obj = empresaService.fromDTO(objDto);
		obj = empresaService.inserindo(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// Update
	@RequestMapping(value="/{id}", method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alterar(@RequestBody Empresa obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = empresaService.alterando(obj);
		return ResponseEntity.noContent().build();
	}
	
	// Delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		empresaService.deletando(id);
		return ResponseEntity.noContent().build();
	}

	// Page
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<EmpresaDTO>> paginacao(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nomeEmpresa") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Empresa> lista = empresaService.paginacao(page, linesPerPage, orderBy, direction);
		Page<EmpresaDTO> listaDTO = lista.map(obj -> new EmpresaDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
}
