package com.pasquali.vagas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pasquali.vagas.domain.Contrato;
import com.pasquali.vagas.services.ContratoService;

@RestController
@RequestMapping(value="/contrato")
public class ContratoResource {
	
	@Autowired
	private ContratoService contratoService;

	//FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Contrato objeto = contratoService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	//ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Contrato>> listando() {
		List<Contrato> lista = contratoService.listar();
		return ResponseEntity.ok().body(lista);
	}
	

}
