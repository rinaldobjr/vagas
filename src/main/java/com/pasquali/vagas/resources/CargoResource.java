package com.pasquali.vagas.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.pasquali.vagas.domain.Cargo;
import com.pasquali.vagas.dto.CargoDTO;
import com.pasquali.vagas.services.CargoService;

@RestController
@RequestMapping(value="/cargo")
public class CargoResource {
	
	@Autowired
	private CargoService cargoService;
	
	// FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Cargo objeto = cargoService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	// ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<CargoDTO>> listando() {
		List<Cargo> lista = cargoService.listar();
		List<CargoDTO> listaDTO = lista.stream().map(obj -> new CargoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	// Insert
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody CargoDTO objDto) {
		Cargo obj = cargoService.fromDTO(objDto);
		obj = cargoService.inserindo(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
	// Update
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody Cargo obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = cargoService.alterando(obj);
		return ResponseEntity.noContent().build();
	}

	// Delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		cargoService.deletando(id);
		return ResponseEntity.noContent().build();
	}

	// Page
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CargoDTO>> paginacao(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nomeCargo") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Cargo> lista = cargoService.paginacao(page, linesPerPage, orderBy, direction);
		Page<CargoDTO> listaDTO = lista.map(obj -> new CargoDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
	

}


//private SessionFactory sessionFactory;
//Statistics estatisticas = sessionFactory.getStatistics();
//System.out.println(estatisticas.getQueryExecutionCount());
