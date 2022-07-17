package com.pasquali.vagas.resources;

import java.net.URI;
import java.util.List;

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

import com.pasquali.vagas.domain.Nivel;
import com.pasquali.vagas.dto.NivelDTO;
import com.pasquali.vagas.services.NivelService;

@RestController
@RequestMapping(value="/nivel")
public class NivelResource {
	
	@Autowired
	private NivelService nivelService;
	
	// FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Nivel objeto = nivelService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	// ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Nivel>> listando() {
		List<Nivel> lista = nivelService.listar();
		return ResponseEntity.ok().body(lista);
	}
	
	
	// Insert
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> inserir(@Valid @RequestBody NivelDTO objDto) {
			Nivel obj = nivelService.fromDTO(objDto);
			obj = nivelService.inserindo(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
			
		// Update
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Void> alterar(@RequestBody Nivel obj, @PathVariable Integer id) {
			obj.setId(id);
			obj = nivelService.alterando(obj);
			return ResponseEntity.noContent().build();
		}

		// Delete
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> deletar(@PathVariable Integer id) {
			nivelService.deletando(id);
			return ResponseEntity.noContent().build();
		}
	
	
	// Page
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<NivelDTO>> paginacao(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nomeNivel") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Nivel> lista = nivelService.paginacao(page, linesPerPage, orderBy, direction);
		Page<NivelDTO> listaDTO = lista.map(obj -> new NivelDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
}
