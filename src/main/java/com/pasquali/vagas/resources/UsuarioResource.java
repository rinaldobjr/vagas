package com.pasquali.vagas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pasquali.vagas.domain.Usuario;
import com.pasquali.vagas.services.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	// FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Usuario objeto = usuarioService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	// ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listando() {
		List<Usuario> lista = usuarioService.listar();
		return ResponseEntity.ok().body(lista);
	}

}
