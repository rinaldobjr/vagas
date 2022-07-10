package com.pasquali.vagas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pasquali.vagas.domain.LocalTrabalho;
import com.pasquali.vagas.services.LocalTrabalhoService;

@RestController
@RequestMapping(value="/localtrabalho")
public class LocalTrabalhoResource {
	
	@Autowired
	private LocalTrabalhoService localTrabalhoService;
	
	//FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		LocalTrabalho objeto = localTrabalhoService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	//ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<LocalTrabalho>> listando() {
		List<LocalTrabalho> lista = localTrabalhoService.listar();
		return ResponseEntity.ok().body(lista);
	}
	

}
