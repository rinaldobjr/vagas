package com.pasquali.vagas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pasquali.vagas.domain.VagaStatus;
import com.pasquali.vagas.services.VagaStatusService;

@RestController
@RequestMapping(value="/vagastatus")
public class VagaStatusResource {
	
	@Autowired
	private VagaStatusService vagaStatusService;
	
	//FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		VagaStatus objeto = vagaStatusService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	//ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<VagaStatus>> listando() {
		List<VagaStatus> lista = vagaStatusService.listar();
		return ResponseEntity.ok().body(lista);
	}
	
}
