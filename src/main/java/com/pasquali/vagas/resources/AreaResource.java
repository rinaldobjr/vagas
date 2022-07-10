package com.pasquali.vagas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pasquali.vagas.domain.Area;
import com.pasquali.vagas.services.AreaService;

@RestController
@RequestMapping(value="/area")
public class AreaResource {
	
	@Autowired
	private AreaService areaService;
	
	//FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Area objeto = areaService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	//ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Area>> listando() {
		List<Area> lista = areaService.listar();
		return ResponseEntity.ok().body(lista);
	}
	

}
