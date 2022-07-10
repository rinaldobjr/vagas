package com.pasquali.vagas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pasquali.vagas.domain.Empresa;
import com.pasquali.vagas.services.EmpresaService;

@RestController
@RequestMapping(value="/empresa")
public class EmpresaResource {

	@Autowired
	private EmpresaService empresaService;
	
	//FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> findById(@PathVariable Integer id) {
			Empresa objeto = empresaService.buscar(id);
			return ResponseEntity.ok().body(objeto);
		}
	
	//ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Empresa>> listando() {
		List<Empresa> lista = empresaService.listar();
		return ResponseEntity.ok().body(lista);
	}
}
