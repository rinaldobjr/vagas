package com.pasquali.vagas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pasquali.vagas.domain.Area;
import com.pasquali.vagas.services.AreaService;

@RestController
@RequestMapping(value="/area")
public class AreaResource {
	
	@Autowired
	private AreaService areaService;
	
	//FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Area> findById(@PathVariable Integer id) {
		Area objeto = areaService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	//ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Area>> listando() {
		List<Area> lista = areaService.listar();
		return ResponseEntity.ok().body(lista);
	}
	
	// Insert
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Area obj) {
		obj = areaService.inserindo(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// Update
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
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
	
}
