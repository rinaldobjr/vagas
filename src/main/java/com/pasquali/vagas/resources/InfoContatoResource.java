package com.pasquali.vagas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pasquali.vagas.domain.InfoContato;
import com.pasquali.vagas.services.InfoContatoService;

@RestController
@RequestMapping(value="/infocontato")
public class InfoContatoResource {
	
	@Autowired
	private InfoContatoService infoContatoService;
	
	//FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		InfoContato objeto = infoContatoService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	//ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<InfoContato>> listando() {
		List<InfoContato> lista = infoContatoService.listar();
		return ResponseEntity.ok().body(lista);
	}
	

}
